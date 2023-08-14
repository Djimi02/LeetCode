public class Palindrom {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String number = String.valueOf(x);
        int lenghtOfNum = number.length();

        String firstHalf = number.substring(0, lenghtOfNum/2);
        String secondHalf = number.substring(lenghtOfNum/2, lenghtOfNum);

        System.out.println(firstHalf.length());
        for (int i = 0; i < firstHalf.length(); i++) {
            if (firstHalf.charAt(i) != secondHalf.charAt(secondHalf.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Palindrom().isPalindrome(1001));
    }
}
