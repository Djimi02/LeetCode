public class LongestCommonPrefix {
    public String longestCommonPrefixInTwoNumbers(String str1, String str2){
        String longestPrefix = "";
        int minLenght = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLenght; i++) {
            if (str1.charAt(i) == str2.charAt(i)){
                longestPrefix += str1.charAt(i);
            }
            else {
                break;
            }
        }
        return longestPrefix;
    }

    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = strs[0];
        String currentPrefix = "";

        for (int i = 1; i < strs.length; i++) {
            currentPrefix = longestCommonPrefixInTwoNumbers(strs[i-1], strs[i]);
            
            if (currentPrefix.length() < longestCommonPrefix.length()) {
                longestCommonPrefix = currentPrefix;
            }
        }

        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"}));
        // System.out.println(new LongestCommonPrefix().longestCommonPrefixInTwoNumbers("asd", "wrwer"));
    }
}
