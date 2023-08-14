public class ContainerWithMostWaterVarTwo {
    public int maxArea(int[] height) {
        int width = 0;
        int heightOfSmallerLine = 0;
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        int currentWater = 0;

        while (left < right) {
            width = right - left;
            heightOfSmallerLine = Math.min(height[left], height[right]);
            currentWater = width * heightOfSmallerLine;
            maxWater = Math.max(maxWater, currentWater);

            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
