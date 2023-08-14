public class SearchA2DMatrix {

    public boolean binarySearch(int[] matrix, int target) {
        if (matrix.length == 1) {
            if (matrix[0] == target) {
                return true;
            } else {
                return false;
            }
        }

        int minIndex = 0;
        int maxIndex = matrix.length - 1;
        boolean output = false;

        while (minIndex < maxIndex) {
            if (matrix[minIndex] == target || matrix[maxIndex] == target) {
                return true;
            }

            int midIndex = (maxIndex + minIndex) / 2;
            if (target <= matrix[midIndex]) {
                maxIndex = midIndex;
            } else {
                minIndex = midIndex + 1;
            }
        }

        return output;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        boolean output = false;

        for (int i = 0; i < matrix.length; i++) {
            if (target < matrix[i][0] || matrix[i][matrix[0].length - 1] < target) {
                continue;
            }

            return binarySearch(matrix[i], target);
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3},
                // { 10, 11, 16, 20 },
                // { 23, 30, 34, 60 }
        };

        int[] singleRowMatrix = { 1, 3, 5, 7, 8, 9 };
        System.out.println(new SearchA2DMatrix().binarySearch(singleRowMatrix, 2));
        // System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 3));

    }
}
