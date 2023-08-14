public class ReverseInteger {
    public int reverse(int x) {
        int revertedInt = 0;  
        long nextNum = 0l;
        
        if (x < 10 && x >= 0) {
            return x;
        }

        while (x != 0) {
            nextNum = (long)((long)revertedInt * 10 + ((long)x % 10));
            // System.out.println(nextNum);
            // System.out.println(Long.MAX_VALUE);
            if (nextNum <= Integer.MIN_VALUE || nextNum >= Integer.MAX_VALUE) {
                return 0;
            } else {
                revertedInt = (int)nextNum;
                x /= 10;
            }
        }
        return revertedInt;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-236469));
        // System.out.println((Long)(2147483648));
    }
}
