public class SpiralMatrix2 {
    
    public int[][] generateMatrix(int n) {

        int[][] outputMatrix = new int[n][n];

        int topBound = 0;
        int rightBound = outputMatrix[0].length - 1;
        int bottomBound = outputMatrix.length - 1;
        int leftBound = 0;

        int row = 0;
        int col = 0;

        int nextNum = 0;
        while (row <= rightBound || row >= leftBound || col >= topBound || col <= bottomBound) {

            if (col <= rightBound) {
                for (; col <= rightBound; col++) {
                    // output.add(matrix[row][col]);
                    
                    nextNum++;
                    outputMatrix[row][col] = nextNum;
                }
                col--;
                topBound++;
                row++;
            } else {
                break;
            }

            if (row <= bottomBound) {
                for (; row <= bottomBound; row++) {
                    // output.add(matrix[row][col]);
                    nextNum++;
                    outputMatrix[row][col] = nextNum;
                }
                row--;
                rightBound--;
                col--;
            } else {
                break;
            }

            if (col >= leftBound) {
                for (; col >= leftBound; col--) {
                    // output.add(matrix[row][col]);
                    nextNum++;
                    outputMatrix[row][col] = nextNum;
                }
                col++;
                bottomBound--;
                row--;
            } else {
                break;
            }

            if (row >= topBound) {
                for (; row >= topBound; row--) {
                    // output.add(matrix[row][col]);
                    nextNum++;
                    outputMatrix[row][col] = nextNum;
                }
                row++;
                leftBound++;
                col++;
            } else {
                break;
            }
        }
        
        return outputMatrix;
    }

    public static void main(String[] args) {
        int[][] array = new SpiralMatrix2().generateMatrix(3);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
