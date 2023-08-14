public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        // revert one diagonal -> top left - bottom right = transposed
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int num = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = num;
            }
        }

        // reversed 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int num = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = num;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        new RotateImage().rotate(matrix2);
    }
}
