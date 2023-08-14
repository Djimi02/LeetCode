public class FindtheIndexoftheFirstOccurrenceinaString {
        public int strStr(String haystack, String needle) {

            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                if (needle.equals(haystack.substring(i, i + needle.length()))) {
                    return i;
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        System.out.println(new FindtheIndexoftheFirstOccurrenceinaString().strStr("aa", "aa"));
    }
}
