public class MaximumSubarray {
    // public int maxSubArray(int[] nums) {
    //     if (nums.length == 1) {
    //         return nums[0];
    //     }

    //     int maxSum = nums[0];

    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i; j < nums.length; j++) {
    //             int sum = 0;
    //             for (int k = i; k <= j; k++) {
    //                 sum += nums[k];
    //             }
    //             if (sum > maxSum) {
    //                 maxSum = sum;
    //             }
    //         }
    //     }

    //     return maxSum;
    // }

    /**
     * Kadane's Algorithm for finding the biggest sub array sum
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int startIndex = 0, endIndex = 0;
        int currentSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                startIndex = i;
            }
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            if (currentSum > maxSum) {
                endIndex = i;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println("Start index = " + startIndex);
        System.out.println("End index = " + endIndex);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,1,2,9,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(array));
    }
}
