public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int counter = 0;
        boolean bol = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                bol = true;
            }
            if (!bol) {
                counter++;
            }
            if (bol && s.charAt(i) != ' ') {
                counter = 1;
                bol = false;
            }
        }     

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new LengthofLastWord().lengthOfLastWord("asd asd "));
    }
}
