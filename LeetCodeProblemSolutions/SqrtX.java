public class SqrtX {
    
    public int mySqrt(int x) {

        int num = 0;
        int diff = Integer.MAX_VALUE;
        
        for (int i = 0; i <= x; i++) {
            int a = i * i;

            if (x - a < 0) {
                break;
            }

            if (x - a < diff) {
                num = i;
                diff = x - a;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(1));
    }
}
