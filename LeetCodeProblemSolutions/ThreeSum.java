import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private boolean checkIfTripletExists(List<List<Integer>> list, List<Integer> triplet){
        for (List<Integer> triplet1 : list) {
            if (triplet1.get(0) == triplet.get(0) &&
                triplet1.get(1) == triplet.get(1) &&
                triplet1.get(2) == triplet.get(2)) {
                return true;
            }
        }
        return false;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        // Sorting numbers
        nums = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(nums));

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    if (!checkIfTripletExists(output, triplet)) {
                        output.add(triplet);
                    }

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return output;
    }


    public static void main(String[] args) {
        List<List<Integer>> output = new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> list : output) {
            System.out.println(list);
        }
    }
}
