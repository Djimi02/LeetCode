public class SujikoSolver {
    private int topLeftGroup;
    private int topRightGroup;
    private int bottomLeftGroup;
    private int bottomRightGroup;

    private int solutionCount;

    private int matrix[][];
    private boolean[] usedNumbers;

    public SujikoSolver() {
        this.matrix = new int[3][3];
        this.usedNumbers = new boolean[9];
        this.solutionCount = 0;
    }

    public SujikoSolver(int num1, int num2, int num3, int num4) {
        this.topLeftGroup = num1;
        this.topRightGroup = num2;
        this.bottomLeftGroup = num3;
        this.bottomRightGroup = num4;
        this.matrix = new int[3][3];
        this.usedNumbers = new boolean[9];
        this.solutionCount = 0;
    }

    public int getTopLeftGroup() {
        return this.topLeftGroup;
    }

    public void setTopLeftGroup(int topLeftGroup) {
        this.topLeftGroup = topLeftGroup;
    }

    public int getTopRightGroup() {
        return this.topRightGroup;
    }

    public void setTopRightGroup(int topRightGroup) {
        this.topRightGroup = topRightGroup;
    }

    public int getBottomLeftGroup() {
        return this.bottomLeftGroup;
    }

    public void setBottomLeftGroup(int bottomLeftGroup) {
        this.bottomLeftGroup = bottomLeftGroup;
    }

    public int getBottomRightGroup() {
        return this.bottomRightGroup;
    }

    public void setBottomRightGroup(int bottomRightGroup) {
        this.bottomRightGroup = bottomRightGroup;
    }

    public int getSolutionCount() {
        return this.solutionCount;
    }

    private boolean isGroup1Valid() {
        int sum = matrix[0][0] + matrix[0][1] + matrix[1][0] + matrix[1][1];
        if (sum == topLeftGroup) {
            return true;
        }
        return false;
    }

    private boolean isGroup2Valid() {
        int sum = matrix[0][1] + matrix[0][2] + matrix[1][1] + matrix[1][2];
        if (sum == topRightGroup) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isGroup3Valid() {
        int sum = matrix[1][0] + matrix[1][1] + matrix[2][0] + matrix[2][1];
        if (sum == bottomLeftGroup) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isGroup4Valid() {
        int sum = matrix[1][1] + matrix[1][2] + matrix[2][1] + matrix[2][2];
        if (sum == bottomRightGroup) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValid() {
        return isGroup1Valid() && isGroup2Valid() && isGroup3Valid() && isGroup4Valid();
    }

    private void printSolution() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void solve(int row, int col) {
        // Base case: if the grid is full, check if it is valid
        if (row == 3) {
            if (isValid()) {
                solutionCount++;
                printSolution();
                return;
            }
        }

        // Try each number from 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (!usedNumbers[num - 1]) {
                // Mark the number as used
                usedNumbers[num - 1] = true;
                // Place the number in the current cell
                matrix[row][col] = num;
                // Move to the next cell
                if (col == 2) {
                    solve(row + 1, 0);
                } else {
                    solve(row, col + 1);
                }
                // Backtrack
                matrix[row][col] = 0;
                usedNumbers[num - 1] = false;
            }
        }
    }

    // FOR TESTING PURPOSES
    public static void main(String[] args) {
        SujikoSolver solver = new SujikoSolver(27, 23, 19, 12);
        solver.solve(0, 0);
    }

}
