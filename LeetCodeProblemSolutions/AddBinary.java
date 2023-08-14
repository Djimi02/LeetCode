public class AddBinary {
    
    public String addBinary(String a, String b) {

        String output = "";

        int sLength;
        if (a.length() >= b.length()) {
            sLength = b.length();
        } else {
            sLength = a.length();
        }

        int overFlow = 0;

        for (int i = 0; i < sLength; i++) {
            int numA = Character.getNumericValue(a.charAt(a.length() - i - 1));
            int numB = Character.getNumericValue(b.charAt(b.length() - i - 1));

            int currentNum = 0;

            if (numA + numB + overFlow > 1) {
                currentNum = numA + numB + overFlow - 2;
                overFlow = 1;
            } else {
                currentNum = numA + numB + overFlow;
                overFlow = 0;
            }

            output = Character.toString(((char) currentNum) + '0') + output;
        }

        if (a.length() > b.length()) {
            for (int i = a.length() - b.length() - 1; i != -1; i--) {
                int numA = Character.getNumericValue(a.charAt(i));

                int currentNum = 0;

                if (numA + overFlow > 1) {
                    currentNum = numA + overFlow - 2;
                    overFlow = 1;
                } else {
                    currentNum = numA + overFlow;
                    overFlow = 0;

                }
    
                output = Character.toString(((char) currentNum) + '0') + output;
            }
        } else if (a.length() < b.length()) {
            for (int i = b.length() - a.length() - 1; i != -1; i--) {
                int numB = Character.getNumericValue(b.charAt(i));

                int currentNum = 0;

                if (numB + overFlow > 1) {
                    currentNum = numB + overFlow - 2;
                    overFlow = 1;
                } else {
                    currentNum = numB + overFlow;
                    overFlow = 0;
                }
    
                output = Character.toString(((char) currentNum) + '0') + output;
            }
        }

        if (overFlow == 1) {
            output = "1" + output;
        }
     
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("100", "110010"));
    }
}
