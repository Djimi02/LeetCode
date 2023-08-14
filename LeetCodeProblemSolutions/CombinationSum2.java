import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    // the final output
    private List<List<Integer>> output = new ArrayList<>();
    // local solution list that sums to the target
    private List<Integer> list = new ArrayList<>();
    // candidates but in list
    private List<Integer> candidatesList;

    List<Integer> indexisOfUsedNumbers = new ArrayList<>();

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

    protected List<List<Integer>> combinationSum22(List<Integer> candidates, int target) {
        // finding the current sum
        int sum = 0;
        for (int i : list) {
            sum += i;
        }

        for (int i = 0; i < candidates.size(); i++) {

            if (candidates.get(i) == 0) {
                continue;
            }

            // if (list.contains(candidates.get(i))) {
            //     continue;
            // }

            if (candidates.get(i) + sum > target) { // if it doesnt with the current candidate try with the next one
                continue;
            }

            if (candidates.get(i) + sum == target) { // if this is a solution
                list.add(candidates.get(i)); // add it to the list
                if (!checkIfTupleExists(output, list)) { // if this solution does not exist already
                    output.add(new ArrayList<>(list)); // add it to the list of solutions
                }
                list.remove(list.size() - 1); // remove the last element, so it can try another combination after that
                continue;
            }

            if (candidates.get(i) + sum < target) { // in case of possible future solution
                list.add(candidates.get(i)); // add the currecnt number to local solution list
                candidates.set(i, 0);
                indexisOfUsedNumbers.add(i);
                combinationSum22(candidates, target); // go one level deeper
            }

        }

        // back-track starting here
        if (!list.isEmpty()) { // if it is not already empty
            candidates.set(indexisOfUsedNumbers.get(indexisOfUsedNumbers.size() - 1), list.get(list.size() - 1));
            indexisOfUsedNumbers.remove(indexisOfUsedNumbers.size() - 1);
            list.remove(list.size() - 1);
        }
        return output;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        candidatesList = new ArrayList<>();

        for (int element : candidates) {
            candidatesList.add(element);
        }
        return combinationSum22(candidatesList, target);
    }

    public static void main(String[] args) {
        int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> output = new CombinationSum2().combinationSum2(candidates, target);
        for (List<Integer> list : output) {
            System.out.println(list.toString());
        }

    }

}
