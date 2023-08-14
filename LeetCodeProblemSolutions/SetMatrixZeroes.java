public class SetMatrixZeroes {

    private void setZerosRowCol(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix[0].length; i++) { // filling the row with 0s
            matrix[row][i] = 0;
        }

        for (int i = 0; i < matrix.length; i++) { // filling the col with 0s
            matrix[i][col] = 0;
        }
    }
    
    public void setZeroes(int[][] matrix) {
        int[] rowCordinates = new int[matrix[0].length * matrix.length];
        int[] colCordinates = new int[rowCordinates.length];
        int pointer = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowCordinates[pointer] = i;
                    colCordinates[pointer] = j;
                    pointer++;
                }
            }
        }

        for (int i = 0; i < pointer; i++) {
            setZerosRowCol(matrix, rowCordinates[i], colCordinates[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1},
            // {1, 0, 1},
            // {1, 1, 1}
        };

        new SetMatrixZeroes().setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

}
