public class MissingNumberInArray {
    
    int missingNumber(int n, int arr[]) {
        int supposedSum = 0;
        for (int i = 1; i <= n; i++) {
            supposedSum += i;
        }

        int realSum = 0;
        for (int i = 0; i < arr.length; i++) {
            realSum += arr[i];
        }

        return supposedSum - realSum;
    }

    public static void main(String[] args) {
        
    }
}