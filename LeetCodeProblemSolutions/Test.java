public class Test {
    public static void main(String[] args){
        char[] test={'1','2','3'};
        test(test);
        System.out.println(test[0]+" "+test[1]+" "+test[2]);
    }
    
    static void test(char[] test){
        test[0]='5';
    }
}
