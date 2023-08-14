public class NumsOfStepsToReduceToZero {
    public int numberOfSteps(int num) {
        int counter = 0;
        
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new NumsOfStepsToReduceToZero().numberOfSteps(123));
    }
}
