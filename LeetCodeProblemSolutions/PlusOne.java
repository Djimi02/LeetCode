public class PlusOne {

    private int[] traverseArrayOneRight(int[] digits) {
        int[] output = new int[digits.length + 1];

        for (int i = 1; i < output.length; i++) {
            output[i] = digits[i-1];
        }

        return output;
    }

    public int[] plusOne(int[] digits) {

        boolean overflow = false;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (overflow) {
                digits[i] += 1;
            }

            if (digits[i] > 9) {
                overflow = true;
                digits[i] = 0;
            } else {
                overflow = false;
                break;
            }
        }

        if (overflow) {
            digits = traverseArrayOneRight(digits);
            digits[0] = 1;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] result = new PlusOne().plusOne(new int[] {8,9,9,9});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
}
