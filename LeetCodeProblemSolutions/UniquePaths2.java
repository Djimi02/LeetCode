public class UniquePaths2 {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            return 1;
        }
        
        boolean obstacleInRowDetected = false;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                obstacleInRowDetected = true;
                continue;
            }  

            if (obstacleInRowDetected) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }

        boolean obstacleInColDetected = false;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
                obstacleInColDetected = true;
            } 

            if (obstacleInColDetected) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    // below is brute force variant
    // private int counter = 0;

    // private void uniquePathsWithObstaclesRec(int[][] obstacleGrid, int row, int col) {
    //     if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
    //         counter++;
    //         return;
    //     }

    //     if (row + 1 < obstacleGrid.length && obstacleGrid[row + 1][col] != 1) {
    //         uniquePathsWithObstaclesRec(obstacleGrid, row + 1, col);
    //     }

    //     if (col + 1 < obstacleGrid[0].length && obstacleGrid[row][col + 1] != 1) {
    //         uniquePathsWithObstaclesRec(obstacleGrid, row, col + 1);
    //     }
    // }

    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    //     if (obstacleGrid[0][0] == 1) {
    //         return 0;
    //     }

    //     if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
    //         return 1;
    //     }

    //     uniquePathsWithObstaclesRec(obstacleGrid, 0, 0);

    //     return counter;

    // }

    public static void main(String[] args) {
        int[][] array = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        int[][] array2 = new int[][] {{0,1}, {0,0}};
        int[][] array3 = new int[][] {{1}};
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(array3));
    }
}
