import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int lastPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[lastPosition] = nums[i];
                lastPosition++;
            }
        }

        return lastPosition;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 3,2,2,3 };
        System.out.println(new RemoveElement().removeElement(array, 3));
    }
}
