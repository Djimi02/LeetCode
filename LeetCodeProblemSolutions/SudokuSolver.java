
public class SudokuSolver {
    private final int BOARD_SIZE = 9;
    private boolean solved = false;

    // method that prints the board
    private void printBoard(char[][] board){
        if (board == null) {
            System.out.println("board is null");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board.length; j++) {
                System.out.print("\"" + board[i][j] + "\"");
                if (j != 8) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i != 8) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    // find the next empty cell. Hence board[i][j] == '.'
    private int[] nextEmptyCell(int[] currentCell, char[][] board){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // solves the sudoko
    private void solveSudoku1(char[][] board, int[] cordinateOfLastCell) {
        int[] cordinatesOfNextEmptyCell = nextEmptyCell(cordinateOfLastCell, board);

        if (cordinatesOfNextEmptyCell[0] == -1 || cordinatesOfNextEmptyCell[1] == -1) {
            solved = true;
            return;
        }

        for (int i = 1; i <= 9; i++) {
            board[cordinatesOfNextEmptyCell[0]][cordinatesOfNextEmptyCell[1]] = (char)(i+'0');

            if (new ValidSudoku().isValidSudoku(board)) {
                solveSudoku1(board, cordinatesOfNextEmptyCell);    
            }
            if (solved) {
                return; 
            }
        }

        board[cordinatesOfNextEmptyCell[0]][cordinatesOfNextEmptyCell[1]] = '.';
    }

    
    
    /** 
     * @param board = input array = sudoko board
     * @pre {@code board != null && board is not violated sudoko}
     * @post {board == solution to the sudoko}
     * @throws NullPointerException, IllegalArgumentException
     */
    public void solveSudoku(char[][] board) throws NullPointerException, IllegalArgumentException {
        if (board == null) {
            throw new NullPointerException("board cannot be null");
        }
        if (!new ValidSudoku().isValidSudoku(board)) {
            throw new IllegalArgumentException("board is initially violated");
        }

        solveSudoku1(board, new int[]{0,0});
        printBoard(board);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'} };

            char[][] solvedBoard = new char[][] {
                {'5','3','4','6','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},
                {'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},
                {'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},
                {'3','4','5','2','8','6','7','.','9'} };

        new SudokuSolver().solveSudoku(board);
        // System.out.println(Arrays.toString(new SudokuSolver().nextEmptyCell(new int[]{0,0}, board)));
        // System.out.println((char)1);
    }
}
