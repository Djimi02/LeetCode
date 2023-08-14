public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int width = 0;
        int heightOfSmallerLine = 0;
        int maxWater = 0;
        int currentWater = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                width = j - i;

                heightOfSmallerLine = Math.min(height[i], height[j]);

                currentWater = width * heightOfSmallerLine;

                maxWater = Math.max(maxWater, currentWater);
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
