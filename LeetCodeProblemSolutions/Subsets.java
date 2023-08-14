import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // public List<List<Integer>> subsetsOfGivenSize(int[] nums, int size) {
    //     if (size > nums.length) {
    //         throw new IllegalArgumentException("Size should not be larger than nums.length.");
    //     }

    //     List<List<Integer>> output = new ArrayList<>();

    //     for (int i = 0; i < nums.length - (size-1); i++) {
    //         List<Integer> set = new ArrayList<>();
    //         for (int j = 0; j < size; j++) {
    //             set.add(nums[i+j]);
    //         }
    //         output.add(set);
    //     }
        
    //     return output;
    // }

    public void recursion(List<List<Integer>> sets, int[] nums, int size, int pointer) {

    }

    public List<List<Integer>> subsetOfGivenSize(int[] nums, int size) {
        List<List<Integer>> output = new ArrayList<>();

        int[] set = new int[size];

        return output;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> emptySet = new ArrayList<>();
        output.add(emptySet);

        for (int i = 1; i <= nums.length; i++) {
            // subsetsOfGivenSize(output, nums, i, 0);

            for (List<Integer> set : output) {
                output.add(set);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        // List<List<Integer>> output = new ArrayList<>(); new Subsets().subsetsOfGivenSize(output, nums, 3, 0);

        List<List<Integer>> output = new Subsets().subsets(nums);

        for (List<Integer> list : output) {
            System.out.println(list);
        }
    }
}