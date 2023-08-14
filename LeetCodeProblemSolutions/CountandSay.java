public class CountandSay {

    
    /** 
     * The method, given string numbers(0-9) returns how would you say them
     * example: sayString("1123") = 211213
     * explanation: two ONEs, one TWO, one THREE
     * @param str = string of numbers(0-9)
     * @return String = string that says how would you say the inputted value
     * @pre it is assumed that str should be a string of integers
     * @post \result = string that says how would you say the inputted value
     */
    private String sayString(String str){
        int counter = 0;
        int lastNum = Integer.parseInt(String.valueOf(str.charAt(0)));
        String output = "";

        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));

            if (num == lastNum) {
                counter++;
            } else {
                output += String.valueOf(counter) + String.valueOf(lastNum);
                lastNum = num;
                counter = 1;
            }

            if (i == str.length() - 1) {
                output += String.valueOf(counter) + String.valueOf(lastNum);
                lastNum = num;
            }
        }

        return output;
    }

    
    /** 
     * this method is hard to explain XD
     * @param n
     * @return String
     */
    public String countAndSay(int n) {
        String output = "1";
        for (int i = 0; i < n - 1; i++) {
            output = sayString(output);
        }
        return output;
    }

    public static void main(String[] args) {
        // System.out.println(new CountandSay().countAndSay(4));
        System.out.println(new CountandSay().sayString("1123"));
    }
}
