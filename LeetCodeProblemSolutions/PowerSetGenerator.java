import java.util.ArrayList;
import java.util.List;

public class PowerSetGenerator<T> {

    private T[] nums;
    private List<List<T>> localSets; // Used for the recursion
    private T[] localSet; // Used for the recursion

    private void addSetToSets() {
        List<T> arr = new ArrayList<>(localSet.length);
        for (int i = 0; i < localSet.length; i++) {
            arr.add(localSet[i]);
        }
        localSets.add(arr);
    }

    /**
     * Recursively finds all the subsets of given size. The size is given by this.localSet.length 
     * @param pointer - points to the element in this.nums
     * @param numOfElement - points to which element of the localSet this iteration refers to
     */
    private void recursion(int pointer, int numOfElement) {

        for (int i = pointer; i < nums.length - (localSet.length - numOfElement); i++) {

            localSet[numOfElement - 1] = nums[i];

            if (numOfElement < localSet.length) {
                recursion(i + 1, numOfElement + 1);
            }

            if (numOfElement == localSet.length) {
                addSetToSets();
            }

        }

    }

    private List<List<T>> subsetsOfGivenSize(int size) {
        localSets = new ArrayList<>();
        localSet = (T[]) new Object[size];

        recursion(0, 1);

        return localSets;
    }

    public List<List<T>> generate(T[] nums) {
        this.nums = nums;

        List<List<T>> output = new ArrayList<>();
        output.add(new ArrayList<T>()); // Adding the empty set

        if (nums.length == 0) {
            return output;
        }

        for (int i = 1; i <= nums.length - 1; i++) { // Going through all possible sizes of subsets
            List<List<T>> set = subsetsOfGivenSize(i);

            output.addAll(set);
        }

        // Adding the set containing all elements
        List<T> allElementsSet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            allElementsSet.add(nums[i]);
        }
        output.add(allElementsSet);

        return output;
    }

    public static void main(String[] args) {
        String[] nums = {"a", "s", "d"};

        // List<List<Integer>> output = new Subsets(nums).subsetsOfGivenSize(2);

        List<List<String>> output = new PowerSetGenerator<String>().generate(nums);

        for (List<String> list : output) {
            System.out.println(list);
        }
    }
}