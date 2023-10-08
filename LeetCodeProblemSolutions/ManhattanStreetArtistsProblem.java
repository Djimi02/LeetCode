public class ManhattanStreetArtistsProblem {

    public int bestSolution = 0;
    private int currentSolution = 0;

    public boolean checkIfRowColAreTaken(boolean[][] grid, int row, int col) {
        for (int i = 0; i < grid[0].length; i++) { // Checking the row
            if (grid[row][i]) {
                return true;
            }
        }

        for (int i = 0; i < grid.length; i++) { // Checking the column
            if (grid[i][col]) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfIntersecIsCrowded(int[][] k, int row, int col) {
        for (int i = 0; i < k.length; i++) {
            if (row == k[i][1] && col == k[i][0]) {
                return true;
            }
        }

        return false;
    }
    
    public void solve(boolean[][] grid, int[][] k, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if (currentSolution > bestSolution) {
                bestSolution = currentSolution;
            }
            return;
        }

        if (!checkIfRowColAreTaken(grid, row, col)) {
            grid[row][col] = true;
            currentSolution++;
        }

        if (col < grid[0].length - 1) {
            solve(grid, k, row, col + 1);
        } else if (col == grid[0].length - 1) {
            solve(grid, k, row + 1, 0);
        }

        // Backtracking starts here
        grid[row][col] = false;
        currentSolution--;
    }

    public static void main(String[] args) {
        boolean[][] grid = new boolean[8][6];
        int[][] k = new int[][] {
            {6,1},
            {1,2},
            {2,2},
            {3,2},
            {5,2},
            {2,4},
            {3,5},
            {4,6},
            {4,7},
            {5,7}
        };

        // System.out.println(new ManhattanStreetArtistsProblem().checkIfIntersecIsCrowded(k, 1, 6));
        ManhattanStreetArtistsProblem object = new ManhattanStreetArtistsProblem();
        object.solve(grid, k, 0, 0);
        System.out.println(object.bestSolution);
    }
}