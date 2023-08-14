import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    
    /** 
     * @param list
     * @param set
     * @return List<List<Integer>>
     */
    public List<List<Integer>> checkIfTripletExists(List<List<Integer>> list, List<Integer> set){
        if (set.get(0) == 0 &&
            set.get(1) == 0 &&
            set.get(2) == 0 &&
            !list.contains(set)) {

            list.add(set);
            return list;
        }

        for (List<Integer> set1 : list) {
            if (set1.contains(set.get(0)) &&
                set1.contains(set.get(1)) &&
                set1.contains(set.get(2))) {
                return list;
            }
        }
        list.add(set);
        return list;
    }

    
    /** 
     * @param nums
     * @return List<List<Integer>>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>(){};

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int j2 = j + 1; j2 < nums.length; j2++) {

                    if (nums[i] + nums[j] + nums[j2] == 0) {
                        List<Integer> set = new ArrayList<>();

                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[j2]);
                        output = checkIfTripletExists(output, set);
                    }
                }
            }
        }
        return output;
    }

    
    /** 
     * @param args
     * 
     */
    public static void main(String[] args) {
        List<List<Integer>> output = new ThreeSum().threeSum(new int[]{-1,0,1,0,0});
        for (List<Integer> list : output) {
            System.out.println(list);
        }
    }
}
