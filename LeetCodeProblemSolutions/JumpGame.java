public class JumpGame {

    private boolean canJumpRecursive(int[] nums, int index) {
        boolean result = false;

        if (index > nums.length - 1) {
            return false;
        }

        if (nums[index] == 0 && index != nums.length-1) {
            return false;
        }

        if (index == nums.length-1) {
            return true;
        }
        
        for (int i = 1; i <= nums[index]; i++) {
            result = canJumpRecursive(nums, index + i);
            if (result) {
                return true;
            }
        }

        return result;
    }

    public boolean canJump(int[] nums) {
        return canJumpRecursive(nums, 0);
    }

    public static void main(String[] args) {
        int[] matrix = new int[] {0};
        System.out.println(new JumpGame().canJump(matrix));
    }
}
