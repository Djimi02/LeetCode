import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        int topBound = 0;
        int rightBound = matrix[0].length - 1;
        int bottomBound = matrix.length - 1;
        int leftBound = 0;

        int row = 0;
        int col = 0;

        List<Integer> output = new ArrayList<>();

        while (row <= rightBound || row >= leftBound || col >= topBound || col <= bottomBound) {
            if (col <= rightBound) {
                for (; col <= rightBound; col++) {
                    output.add(matrix[row][col]);
                }
                col--;
                topBound++;
                row++;
            } else {
                break;
            }

            if (row <= bottomBound) {
                for (; row <= bottomBound; row++) {
                    output.add(matrix[row][col]);
                }
                row--;
                rightBound--;
                col--;
            } else {
                break;
            }

            if (col >= leftBound) {
                for (; col >= leftBound; col--) {
                    output.add(matrix[row][col]);
                }
                col++;
                bottomBound--;
                row--;
            } else {
                break;
            }

            if (row >= topBound) {
                for (; row >= topBound; row--) {
                    output.add(matrix[row][col]);
                }
                row++;
                leftBound++;
                col++;
            } else {
                break;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix2 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int[][] matrix3 = new int[][] { { 1, 2, 3, 4 } };
        int[][] matrix4 = new int[][] { { 1 }, { 2 } };
        int[][] matrix5 = new int[][] { { 1 } };
        System.out.println(new SpiralMatrix().spiralOrder(matrix).toString());
    }
}
