public class IntegerToRoman {
    public int findTheLenghtOfNum(int n){
        int counter = 0;

        while(n != 0){
            counter++;
            n /= 10;
        }
        return counter;
    }

    public String createWholeRoman(String roman, int n){
        int givenNum = n;
        int[] knownNumbers = {1, 5, 10, 50, 100, 500, 1000};
        String[] knownRomanNumbrs = {"I", "V", "X", "L", "C", "D", "M"};
        int indexOfbiggestSmallerNumber = 0;

        while (givenNum != 0) {

            for (int i = 0; i < knownNumbers.length; i++) {
                if (knownNumbers[i] <= givenNum) {
                    indexOfbiggestSmallerNumber = i;
                }
            }

            int lengthOfNum = findTheLenghtOfNum(givenNum);

            if ((int) (givenNum / Math.pow(10, lengthOfNum - 1)) == 4) {
                roman += knownRomanNumbrs[indexOfbiggestSmallerNumber] + knownRomanNumbrs[indexOfbiggestSmallerNumber + 1];
                givenNum -= givenNum;
            }
            else if ((int) (givenNum / Math.pow(10, lengthOfNum - 1)) == 9){
                roman += knownRomanNumbrs[indexOfbiggestSmallerNumber-1] + knownRomanNumbrs[indexOfbiggestSmallerNumber + 1];
                givenNum -= givenNum;
            }
            else {
                roman += knownRomanNumbrs[indexOfbiggestSmallerNumber];
                givenNum -= knownNumbers[indexOfbiggestSmallerNumber];
            }

        }
        return roman;
    }

    public String intToRoman(int num) {
        int lengthOfNum = 0;
        int currentDigit = 0;
        String roman = "";

        while (num != 0) {
            lengthOfNum = findTheLenghtOfNum(num);
            currentDigit = (int) (num / Math.pow(10, lengthOfNum - 1));
            roman = createWholeRoman(roman, (int)(currentDigit * Math.pow(10, lengthOfNum - 1)));
            num = (int) (num - currentDigit * Math.pow(10, lengthOfNum - 1));
        }

        return roman;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(1994));
    }
}
