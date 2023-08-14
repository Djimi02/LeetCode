public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.equals("")) {
            return 0;
        }

        int num = 0;
        boolean isPositive = true;
        boolean isNumStarted = false;
        
        if (s.charAt(0) == '-') {
            isPositive = false;
        }

        if (s.charAt(0) == '+' || s.charAt(0) == '-'){
            s = s.substring(1, s.length());
        }

        if (s.length() == 0){
            return 0;
        }

        if (!(s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {

            if (isNumStarted && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                break;
            }

            long nextNum = 0l;
            if (isPositive) {
                nextNum = (long)((long)num * 10 + (long)Character.getNumericValue(s.charAt(i)));
            }
            else {
                nextNum = (long)((long)num * 10 - (long)Character.getNumericValue(s.charAt(i)));
            }

            if (nextNum <= Integer.MIN_VALUE || nextNum >= Integer.MAX_VALUE) {
                num = nextNum <= Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                break;
            }

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                isNumStarted = true;
                num = (int)nextNum;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        // System.out.println("+123".substring(1, "+123".length()));
        System.out.println(new StringToIntegerAtoi().myAtoi("42"));
    }
}
