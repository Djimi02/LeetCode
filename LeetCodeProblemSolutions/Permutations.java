import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // create method that given array of ints it generate all possible permutations
    // with the numbers in the array and outputs list of lists in java

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(nums, 0, permutations);
        return permutations;
    }

    private static void generatePermutations(int[] nums, int startIndex, List<List<Integer>> permutations) {
        if (startIndex == nums.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            permutations.add(permutation);
        } else {
            for (int i = startIndex; i < nums.length; i++) { // iterate through the elements starting from the current
                                                             // index position

                // swap the current element with the element at the current index position

                int temp = nums[startIndex]; // store the current element in a temp variable

                nums[startIndex] = nums[i]; // swap the current element with the element at the current index position

                nums[i] = temp; // assign back the stored value to its original position

                generatePermutations(nums, startIndex + 1, permutations); // recursively call this method with an
                                                                          // incremented index position

                temp = nums[startIndex]; // store again the current element in a temp variable

                nums[startIndex] = nums[i]; // swap again the current element with the element at the current index
                                            // position

                nums[i] = temp; // assign back again to its original position

            } // end of for loop

        } // end of else statement
    }

    public static void main(String[] args) {

    }
}
