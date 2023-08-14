import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    public List<String> cartesianProduct(List<String> list1, List<String> list2){
        String[] outputArray = new String[list1.size()*list2.size()];

        if (list1.size() == 0) {
            return list2;
        }
        if (list2.size() == 0) {
            return list1;
        }

        int index = 0;
        for (String char1 : list1) {
            for (String char2 : list2) {
                outputArray[index] = char1 + char2;
                index++;
            }
        }
        return Arrays.asList(outputArray);
    }

    public List<String> letterCombinations(String digits) {
        String[][] symbols = {{"a", "b", "c"},{"d", "e", "f"},
                                {"g", "h", "i"}, {"j", "k", "l"},
                                {"m", "n", "o"}, {"p", "q", "r", "s"},
                                {"t", "u", "v"}, {"w", "x", "y", "z"}};

        List<String> outputList = new ArrayList<>();

        if (digits.length() == 0) {
            return outputList;
        }


        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(Character.toString(digits.charAt(i)));
            digit -= 2;
            outputList = cartesianProduct(outputList, Arrays.asList(symbols[digit]));
        }

        return outputList;
    }

    public static void main(String[] args) {
        // List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        // List<String> list2 = new ArrayList<>(Arrays.asList("d", "e", "f"));
        // List<String> list = new LetterCombinationOfPhoneNumber().cartesianProduct(list1,list2);
        // System.out.println(list);

        // int digit = Integer.parseInt(Character.toString("12".charAt(0)));
        // System.out.println(digit);

        System.out.println(new LetterCombinationOfPhoneNumber().letterCombinations("234"));
    }   
}
