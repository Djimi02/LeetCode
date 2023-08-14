public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {

        int repeat = 0;
        if (nums.length % 2 == 0) {
            repeat = nums.length / 2;
        } else {
            repeat = nums.length / 2 + 1;
        }

        int low = 0;
        int high = nums.length - 1;
        for (int i = 0; i < repeat; i++) {
            if (low < high) {
                int position = (high + low) / 2;

                if (nums[position] == target) {
                return position;
                }

                if (target < nums[position]) {
                    high = position;
                } else {
                    low = position;
                }
            }
            else {
                
            }
            
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 4, 5, 1, 2, 3 };
        System.out.println(new SearchinRotatedSortedArray().search(array, 5));
    }
}
