import java.util.Arrays;

public class MergeWithoutExtraSpace {
 
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int i = n - 1; // last index of arr1
        int j = 0;     // first index of arr2
        long temp;

        while (i >= 0 && j < m) {
            if (arr1[i] > arr2[j]) {
                temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                
                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        long[] arr1 = new long[]{1, 3, 5, 7};
        long[] arr2 = new long[]{0, 2, 6, 8, 9};

        MergeWithoutExtraSpace.merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println("Array 1:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }

        System.out.println();

        System.out.println("Array 2:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }
    }
}