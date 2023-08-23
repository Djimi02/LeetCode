public class RemoveDuplicatesFromSortedArrayII {
    
    /**
     * Moves all elements starting at a given index, one index to the back.
     * @param arr - array of ints to move the elements
     * @param index - the index to start at
     * @return - the same array of ints with moved elements. Returns the array 
     * with no change if the index given is larger than the lenght of the array
     * or smaller than 0.
     */
    private int[] moveAllElemensOneIndexBack(int[] arr, int index) {

        if (arr == null) {
            return arr;
        }

        if (index < 0 || index >= arr.length) {
            return arr;
        }

        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }

        return arr;
    }
    
    public int removeDuplicates(int[] nums) {

        int countDuplicates = 1;
        int lastNum = nums[0];
        int duplicateFoundCounter = 0;
        
        int i = 1;
        while (i < nums.length - duplicateFoundCounter) {
            if (nums[i] == lastNum) {
                countDuplicates++;
            } else {
                lastNum = nums[i];
                countDuplicates = 1;
            }

            if (countDuplicates > 2) {
                moveAllElemensOneIndexBack(nums, i);
                duplicateFoundCounter++;
            } else {
                i++;
            }
        }

        return nums.length - duplicateFoundCounter;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};

        // new RemoveDuplicatesFromSortedArrayII().moveAllElemensOneIndexBack(arr, 4);

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + ", ");
        // }

        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(arr));
    }
}
