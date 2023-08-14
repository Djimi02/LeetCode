import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {
    private boolean isBoxValid(char[] box) {
        List<Character> existingNumbers = new ArrayList<>();

        for (int i = 0; i < box.length; i++) {
            if (box[i] == '.') {
                continue;
            }

            if (existingNumbers.contains(box[i])) {
                return false;
            }
            else {
                existingNumbers.add(box[i]);
            }
        }
        // System.out.println(Arrays.toString(box));
        return true;
    }

    private boolean isColumnValid(char[] column) {

        for (int i = 0; i < column.length; i++) {
            for (int j = i + 1; j < column.length; j++) {
                if (column[i] == '.' || column[j] == '.') {
                    continue;
                }

                if (column[i] == column[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isRowValid(char[] row) {

        for (int i = 0; i < row.length; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if (row[i] == '.' || row[j] == '.') {
                    continue;
                }

                if (row[i] == row[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        // checking every row
        for (int i = 0; i < board.length; i++) {
            if (!isRowValid(board[i])) {
                // System.out.println("not valid row");
                return false;
            }
        }

        // checking every column
        char[] helperArray = new char[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                helperArray[j] = board[j][i];
            }

            if (!isColumnValid(helperArray)) {
                // System.out.println("not valid column");
                return false;
            }
        }

        // checking every box
        for (int i = 0; i < helperArray.length; i+=3) {
            for (int j = 0; j < helperArray.length; j+=3) {
                helperArray[0] = board[i][j];
                helperArray[1] = board[i][j+1];
                helperArray[2] = board[i][j+2];
                helperArray[3] = board[i+1][j];
                helperArray[4] = board[i+1][j+1];
                helperArray[5] = board[i+1][j+2];
                helperArray[6] = board[i+2][j];
                helperArray[7] = board[i+2][j+1];
                helperArray[8] = board[i+2][j+2];

                if (!isBoxValid(helperArray)) {
                    // System.out.println("not valid box");
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'.','.','.','.','5','.','.','1','.'},
            {'.','4','.','3','.','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','1'},
            {'8','.','.','.','.','.','.','2','.'},
            {'.','.','2','.','7','.','.','.','.'},
            {'.','1','5','.','.','.','.','.','.'},
            {'.','.','.','.','.','2','.','.','.'},
            {'.','2','.','9','.','.','.','.','.'},
            {'.','.','4','.','.','.','.','.','.'} };

        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
