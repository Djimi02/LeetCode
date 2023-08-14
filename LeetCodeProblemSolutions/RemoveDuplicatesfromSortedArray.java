import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        
        int lastPosition = 1;
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            if (currentNum != lastNum) {
                nums[lastPosition] = currentNum;
                lastPosition++;
                lastNum = currentNum;
            }
        }

        return lastPosition;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,2};
        System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(array));
    }
}