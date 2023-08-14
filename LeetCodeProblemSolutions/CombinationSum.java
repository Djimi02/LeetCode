import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    // the final output
    private List<List<Integer>> output = new ArrayList<>();
    // local solution list that sums to the target
    private List<Integer> list = new ArrayList<>();

    // checking if a solution is already present
    protected boolean checkIfTupleExists(List<List<Integer>> bigList, List<Integer> smallList) {
        for (List<Integer> list : bigList) {
            List<Integer> existing = new ArrayList<>(list);

            for (Integer integer : smallList) {
                if (existing.contains(integer)) {
                    existing.remove(integer);
                }
            }

            if (!existing.isEmpty()) {
                continue;
            } else {
                return true;
            }
        }

        return false;
    }

    // 
    protected void combinationSum1(int[] candidates, int target){
        // finding the current sum
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        
        for (int i = 0; i < candidates.length; i++) {


            if (candidates[i] + sum > target) { // if it doesnt with the current candidate try with the next one
                continue;
            }

            if (candidates[i] + sum == target) { // if this is a solution
                list.add(candidates[i]); // add it to the list
                if (!checkIfTupleExists(output, list)) { // if this solution does not exist already
                    output.add(new ArrayList<>(list)); // add it to the list of solutions
                }
                list.remove(list.size() - 1); // remove the last element, so it can try another combination after that
                continue;
            }

            if (candidates[i] + sum < target) { // in case of possible future solution
                list.add(candidates[i]); // add the currecnt number to local solution list
                combinationSum(candidates, target); // go one level deeper
            }

        }
        // back-track starting here

        if (!list.isEmpty()) { // if it is not already empty
            list.remove(list.size() - 1); 
        }
        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum1(candidates, target);

        return output;
    }
    

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> output = new CombinationSum().combinationSum(candidates, target);
        for (List<Integer> list : output) {
            System.out.println(list.toString());
        }

        // List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 2, 3));
        // List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        // List<Integer> list3 = new ArrayList<>(Arrays.asList(3, 2, 4));
        // List<List<Integer>> output1 = new ArrayList<>();
        // output1.add(list1);
        // output1.add(list2);
        // System.out.println(new CombinationSum().checkIfTupleExists(output1, list3));
    }
}
