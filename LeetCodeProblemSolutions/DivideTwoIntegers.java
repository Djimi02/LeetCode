public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        Boolean negativeDividend = false;
        if (dividend == Integer.MIN_VALUE) {
            dividend += 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            divisor += 1;
        }

        if (dividend < 0) {
            dividend = Math.abs(dividend);
            negativeDividend = true;
        }
        Boolean negativeDivisor = false;
        if (divisor < 0) {
            divisor = Math.abs(divisor);
            negativeDivisor = true;
        }

        int counter = 0;
        while (dividend - divisor >= 0) {
            dividend -= divisor;
            if (counter != Integer.MAX_VALUE) {
                counter++;
            }
        }

        if (negativeDividend && negativeDivisor) {
            return counter;
        }
        else if (negativeDividend || negativeDivisor){
            return counter - counter - counter;
        }
        else{
            return counter;
        }

    }

    public static void main(String[] args) {
        // int a = Math.abs(Integer.MIN_VALUE + 1);
        // System.out.println(a);
        System.out.println(new DivideTwoIntegers().divide(Integer.MIN_VALUE, -1));
    }
}
