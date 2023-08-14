import java.util.ArrayList;
import java.util.List;

public class LongestSubstringNoRep {

    public boolean isThereRepChar(String s){
        List<Character> listOfChar = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (listOfChar.contains(s.charAt(i))) {
                return true;
            }
            listOfChar.add(s.charAt(i));
        }

        // for (int i = 0; i < s.length() - 1; i++) {
        //     for (int j = i+1; j < s.length(); j++) {
        //         if (s.charAt(i) == s.charAt(j)) {
        //             return true;
        //         }
        //     }
        // }

        return false;
    }

    public int lengthOfLongestSubstring(String s) {
        int lengthOfSubString = 0;
        String subString;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                subString = s.substring(i, j+1);

                if (!isThereRepChar(subString) && lengthOfSubString < subString.length()){
                    lengthOfSubString = subString.length();
                }
            }
        }

        return lengthOfSubString;
    }

    public static void main(String[] args) {
        // System.out.println(new LongestSubstringNoRep().isThereRepChar("aba"));
        System.out.println(new LongestSubstringNoRep().lengthOfLongestSubstring("abcabcbb"));
    }
}
