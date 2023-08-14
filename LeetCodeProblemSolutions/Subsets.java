import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private int[] nums;
    private List<List<Integer>> localSets; // Used for the recursion

    public Subsets(int[] nums) {
        this.nums = nums;
    }

    private void recursion() {

        

    }

    private List<List<Integer>> subsetsOfGivenSize(int size) {


        return null;
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;

        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>()); // Adding the empty set

        for (int i = 1; i < nums.length; i++) { // Going through all possible sizes of subsets
            List<List<Integer>> set = subsetsOfGivenSize(i); 

            for (int j = 0; j < set.size(); j++) {
                output.addAll(set);
            }
        }

        // Adding the set containing all elements
        List<Integer> allElementsSet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            allElementsSet.add(nums[i]);
        }
        output.add(allElementsSet);

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        // List<List<Integer>> output = new ArrayList<>(); new Subsets().subsetsOfGivenSize(output, nums, 3, 0);

        // List<List<Integer>> output = new Subsets().subsets(nums);

        // for (List<Integer> list : output) {
        //     System.out.println(list);
        // }
    }
}