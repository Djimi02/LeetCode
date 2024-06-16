import java.util.Arrays;

public class CountTheTriplets {

    private boolean doesNumExists(int[] array, int target, int startIndex) {
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            }
            if (target < array[i]) {
                break;
            }
        }

        return false;
    }
 
    int countTriplet(int arr[], int n) {
        int counter = 0;

        // Sort the array
        arr = Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int sum = arr[i] + arr[j];
                if (doesNumExists(arr, sum, j+1)) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {12, 8, 2, 11, 5, 14, 10};
        int size = arr.length;
        System.out.println(new CountTheTriplets().countTriplet(arr, size));
    }
}