public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        if (target > nums[mid]) {
            return mid + 1;
        }
        else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,6};
        System.out.println(new SearchInsertPosition().searchInsert(array, 2));
    }
}
