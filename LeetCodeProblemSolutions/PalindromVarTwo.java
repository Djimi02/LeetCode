public class PalindromVarTwo {
    public int lenghtOfNum(int n){
        int counter = 0;

        while(n != 0){
            counter++;
            n /= 10;
        }

        return counter;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int lenghtOfNum = lenghtOfNum(x);
        int revertedNumber = 0;

        for (int i = 0; i < lenghtOfNum / 2; i++) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x /= 10;
        }

        x = lenghtOfNum % 2 == 0 ? x : x/10;
        
        return x == revertedNumber;
    }    

    public static void main(String[] args) {
        System.out.println(new PalindromVarTwo().isPalindrome(1001));
    }
}
