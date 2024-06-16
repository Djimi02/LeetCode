import java.util.ArrayList;

public class IndexesOfSubarraySum {
 
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> output = new ArrayList<>();

        int startIndex = -1;
        int endIndex = -1;
        boolean sumFound = false;
        for (int i = 0; i < n; i++) {
            if (sumFound) {
                break;
            }

            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == s) {
                    startIndex = i+1;
                    endIndex = j+1;
                    sumFound = true;
                    break;
                }
            }
        }

        if (startIndex == -1) {
            output.add(startIndex);
        } else {
            output.add(startIndex);
            output.add(endIndex);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(IndexesOfSubarraySum.subarraySum(new int[]{1,2,3,7,5}, 5, 12));
    }
}