public class UniquePaths {

    int solutionCount = 0;

    // bruforce solution
    private void uniquePathsRec(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            solutionCount++;
            return;
        }

        if (row + 1 < m) {
            uniquePathsRec(row+1, col, m, n);
        }
        if (col + 1 < n) {
            uniquePathsRec(row, col+1, m, n);
        }
    }
    
    // public int uniquePaths(int m, int n) {
        
    //     if (m == 1 && n == 1) {
    //         return 1;
    //     }

    //     uniquePathsRec(0, 0, m, n);

    //     return solutionCount;
    // }

    // smart solution
    public int uniquePaths(int m, int n) {

        if (n == 1 && m == 1) {
            return 1;
        }
        
        int[][] array = new int[m][n];
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 1;
        }
        for (int j = 0; j < array[0].length; j++) {
            array[0][j] = 1;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                array[i][j] = array[i-1][j] + array[i][j-1];
            }
        }

        return array[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }
}