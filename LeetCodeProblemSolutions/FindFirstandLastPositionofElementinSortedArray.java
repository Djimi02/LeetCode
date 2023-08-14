import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        // initiate the output array
        int[] output = new int[]{-1, -1};

        // initiate the boudaries of the binary search
        int low = 0;
        int high = nums.length - 1;
        // using binary search
        while (low <= high) {
            int mid = (high + low) / 2;

            // in case we found the target
            if (nums[mid] == target) {
                // initiate the boundaries 
                int rangeLow = mid;
                int rangeHeigh = mid;
                output[0] = rangeLow;
                output[1] = rangeHeigh;

                // start looking expanding the boundaries by looking for numbers equal to the target 
                while (true) {
                    // look down if the lower boundary is not already the first element
                    if (rangeLow != 0 && nums[rangeLow-1] == target) {
                        rangeLow = rangeLow - 1;
                        output[0] = rangeLow;
                    }
                    // look up if the high boundary is not already the last element
                    else if (rangeHeigh != nums.length - 1 && nums[rangeHeigh+1] == target){
                        rangeHeigh = rangeHeigh + 1;
                        output[1] = rangeHeigh;
                    }
                    // in case we did not expand in any direction we are finished 
                    else { return output; }
                }
            }

            // normal binary search look to the left
            if (target < nums[mid]) {
                high = mid - 1;
                continue;
            }

            // normal binary search look to the right
            if (target > nums[mid]) {
                low = mid + 1;
                continue;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(new FindFirstandLastPositionofElementinSortedArray().searchRange(array, 8)));
    }
}
