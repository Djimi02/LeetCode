public class SortColors {
    
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] <= nums[j+1]) {
                    continue;
                }

                int holder = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = holder;
            }
        }
    }

    public static void main(String[] args) {
        int[] singleRowMatrix = { 2,0,2,1,1,0 };

        new SortColors().sortColors(singleRowMatrix);

        for (int i = 0; i < singleRowMatrix.length; i++) {
            System.out.print(singleRowMatrix[i] + ", ");
        }
    }
}
