import java.util.Arrays;

public class NextPermutation {

    public void swap(int a, int b, int[] nums){
        int helper = nums[a];
        nums[a] = nums[b];
        nums[b] = helper;

        // System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (!(nums.length == 1)) {

            int i = nums.length - 1;
            while (i > 0) {
                if (nums[i] > nums[i-1]) {
                    Arrays.sort(nums, i, nums.length);

                    int indexOfSmallestBiggerNumber = 0;
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] > nums[i-1]) {
                            indexOfSmallestBiggerNumber = j;
                            break;
                        }
                    }
                    swap(i-1, indexOfSmallestBiggerNumber, nums);
                    break;
                }

                if (i == 1) {
                    Arrays.sort(nums);
                }
    
                i--;
            } 

        }

        // System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,2,1};

        // new NextPermutation().swap(0, 1, array);
        new NextPermutation().nextPermutation(array);
    }
}
