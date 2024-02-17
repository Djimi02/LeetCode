import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    private Integer binaryToDecimal(String binaryNum) {
        int outputNum = 0;
        int n = binaryNum.length();
        for (int i = n - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(binaryNum.charAt(i));
            outputNum += digit * Math.pow(2, (n - 1) - i);
        }

        return outputNum;
    }

    private List<String> listReflect(List<String> list) {
        List<String> reflectedList = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            reflectedList.add(list.get(i));
        }

        return reflectedList;
    }

    private void addPrefix1(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String dummy = list.get(i);
            dummy = "1" + dummy;
            list.set(i, dummy); 
        }
    }

    private void addPrefix0(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String dummy = list.get(i);
            dummy = "0" + dummy;
            list.set(i, dummy); 
        }
    }

    public List<Integer> grayCode(int n) {
        if (n == 1) {
            return new ArrayList<Integer>() { {add(0); add(1);} };
        } else if (n == 0) {
            return new ArrayList<Integer>() { {add(0);} };
        }

        List<Integer> output = new ArrayList<>();

        List<String> twoBitSequence = new ArrayList<>(){
            {
                add("00"); add("01"); add("11"); add("10");
            }
        };
        
        while (n - 2 > 0) {
            List<String> reflectedList = listReflect(twoBitSequence);
            addPrefix0(twoBitSequence);
            addPrefix1(reflectedList);
            twoBitSequence.addAll(reflectedList);
            n--;
        }

        for (int i = 0; i < twoBitSequence.size(); i++) {
            output.add(binaryToDecimal(twoBitSequence.get(i)));
        }
     
        return output;
    }

    public static void main(String[] args) {
        GrayCode object = new GrayCode();
        // System.out.println(new GrayCode().binaryToDecimal("111"));
        // System.out.println(new GrayCode().flipBit("011", 2));

        // List<String> twoBitSequence = new ArrayList<>(){
        //     {
        //         add("00"); add("01"); add("11"); add("10");
        //     }
        // };
        // List<String> reflectedList = object.listReflect(twoBitSequence);
        // System.out.println(reflectedList);

        // object.addPrefix0(twoBitSequence);
        // System.out.println(twoBitSequence);

        // object.addPrefix1(reflectedList);
        // System.out.println(reflectedList);

        // twoBitSequence.addAll(reflectedList);
        // System.out.println(twoBitSequence);

        System.out.println(object.grayCode(2));
    }
}