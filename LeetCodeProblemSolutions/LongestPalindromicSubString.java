public class LongestPalindromicSubString {
    public boolean isPalindrome(String s){
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if (isPalindrome(s)) {
            return s;
        }

        String subString;
        String longestSubString = "";
        int longestSubStringNum = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                subString = s.substring(i, j + 1);
                // System.out.println(subString);
                if (isPalindrome(subString) && longestSubStringNum < subString.length()) {
                    longestSubString = subString;
                    longestSubStringNum = subString.length();
                }
            }
        }
        return longestSubString;
    }

    public static void main(String[] args) {
        // System.out.println(new LongestPalindromicSubString().isPalindrome("1"));
        System.out.println(new LongestPalindromicSubString().longestPalindrome("cbbd"));
    }
}
