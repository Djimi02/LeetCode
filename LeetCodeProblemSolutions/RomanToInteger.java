import java.util.Scanner;

public class RomanToInteger {

    public boolean isValidSeq(char[] array){
        char currentSymb = array[0];
        int counter = 1;

        for (int i = 1; i < array.length; i++) {
            if (currentSymb == array[i]) {
                counter++;
            } 
            else {
                currentSymb = array[i];
                counter = 1;
            }

            if (counter >= 4){
                return false;
            }
        }

        return true;
    }

    public int singleNumConv(char symb){
        if (symb == 'I') {
            return 1;
        } else if (symb == 'V'){
            return 5;
        } else if (symb == 'X'){
            return 10;
        } else if (symb == 'L'){
            return 50;
        } else if (symb == 'C'){
            return 100;
        } else if (symb == 'D'){
            return 500;
        } else {
            return 1000;
        }
    }

    public int multiNumConv(char[] array){
        int outputNumber = 0;
        int arrayCounter = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (singleNumConv(array[i]) < singleNumConv(array[i+1])) {
                outputNumber += singleNumConv(array[i+1]) - singleNumConv(array[i]);
                i++;
            } else {
                outputNumber += singleNumConv(array[i]);
            } 
            arrayCounter = i;
        }

        if (arrayCounter != array.length - 1) {
            outputNumber += singleNumConv(array[array.length - 1]); 
        }

        return outputNumber;
    }

    public int romanToInt(String s) {
        char array[] = s.toCharArray();

        if (!isValidSeq(array)) {
            System.out.println("The number is not valid!");
            return 0;
        }
        
        if (array.length == 1){
            return singleNumConv(array[0]);
        }
        else {
            return multiNumConv(array);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        System.out.println(new RomanToInteger().romanToInt(s));
    }
}
