
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int dif = Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE;

        int currentSum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int j2 = j+1; j2 < nums.length; j2++) {
                    currentSum = nums[i] + nums[j] + nums[j2];
                    if (Math.abs(target - currentSum) < dif) {
                        dif = Math.abs(target - currentSum);
                        closest = currentSum;
                    }
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] aray = {0,0,0};
        System.out.println(new ThreeSumClosest().threeSumClosest(aray, 1));
    }
}
