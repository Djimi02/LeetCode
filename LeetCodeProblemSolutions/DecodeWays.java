public class DecodeWays {

    private int counter = 0;

    private void recursion(String s) {

        if (s.isEmpty()) {
            counter++;
            return;
        } else if (s.startsWith("0")) {
            return;
        }

        boolean twoChars = false; // helper var

        // Take single char
        char a = s.charAt(0);
        s = s.substring(1);
        if (s.length() > 0) {
            if (s.charAt(0) == '0' && Character.getNumericValue(a) < 3) {
                char b = s.charAt(0);
                s = s.substring(1);
                twoChars = true;
            }
        }
        recursion(s);

        if (!twoChars && s.length() > 0) {
            char b = s.charAt(0);
            if (Character.getNumericValue(a) * 10 + Character.getNumericValue(b) <= 26) {
                s = s.substring(1);
                recursion(s);
            }
        }

    }

    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        recursion(s);
        return counter;
    }

    public static void main(String[] args) {
        // String s = "0";
        // System.out.println(s);
        // s = s.substring(1);
        // System.out.println(s);

        DecodeWays obj = new DecodeWays();
        String s = "06";
        System.out.println(obj.numDecodings(s));
    }
}