public class ClimbingStairs {

    int counter = 0;

    public void climbStairsRec(int n) {
        if (n == 0) {
            counter++;
            return;
        }

        if (n - 1 >= 0) {
            climbStairsRec(n - 1);
        }

        if (n - 2 >= 0) {
            climbStairsRec(n - 2);
        }
    }
    
    public int climbStairs(int n) {
        
        climbStairsRec(n);

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(4));
    }
}
