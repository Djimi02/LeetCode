public class WordSearch {

    private char[][] board;
    private String word;
    private boolean exists;
    private boolean[][] visitted;

    private void clearVisittedArray() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visitted[i][j] = false;
            }
        }
    }

    /**
     * Checks if any of the cells, except the cell with coordinates [row, col], are true,
     * hence visitted.
     * @param row - row coordinate of the cell that should be ignored
     * @param col - column coordinate of the cell that should be ignored
     * @return - if any of the cells, except the cell with coordinates [row, col], are true,
     * hence visitted.
     */
    private boolean checkIfVisittedExists(int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == row && j == col) {
                    continue;
                } else if (visitted[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkIfCharacterExists(char a) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == a) {
                    return true;
                }
            }
        }
        return false;
    }

    private void recursion(int row, int col, int indexOfCharInWord) {

        if ((indexOfCharInWord + 1 >= word.length() && board[row][col] != word.charAt(indexOfCharInWord)) || exists) {
            return;
        }

        if (indexOfCharInWord == (word.length() - 1) && board[row][col] == word.charAt(indexOfCharInWord)) { // This is the case if we find the final letter
            this.exists = true;
            return;
        }

        if (word.charAt(indexOfCharInWord) == board[row][col]) {
            if ((row - 1) >= 0 && board[row - 1][col] == word.charAt(indexOfCharInWord + 1)
                    && !this.visitted[row - 1][col]) { // Check Up
                this.visitted[row][col] = true;
                recursion(row - 1, col, indexOfCharInWord + 1);
            }

            if ((col + 1) < board[0].length && board[row][col + 1] == word.charAt(indexOfCharInWord + 1)
                    && !this.visitted[row][col + 1]) { // Check Right
                this.visitted[row][col] = true;
                recursion(row, col + 1, indexOfCharInWord + 1);
            }

            if ((row + 1) < board.length && board[row + 1][col] == word.charAt(indexOfCharInWord + 1)
                    && !this.visitted[row + 1][col]) { // Check Down
                this.visitted[row][col] = true;
                recursion(row + 1, col, indexOfCharInWord + 1);
            }

            if ((col - 1) >= 0 && board[row][col - 1] == word.charAt(indexOfCharInWord + 1)
                    && !this.visitted[row][col - 1]) { // Check Left
                this.visitted[row][col] = true;
                recursion(row, col - 1, indexOfCharInWord + 1);
            }

            if (checkIfVisittedExists(row, col)) {
                this.visitted[row][col] = false;
                return;
            }
        }

        if (exists) {
            return;
        }

        // Move on
        clearVisittedArray();
        if ((col + 1) < board[0].length) {
            recursion(row, col + 1, 0);
        } else if ((row + 1) < board.length) {
            recursion(row + 1, 0, 0);
        }

    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.exists = false;
        this.visitted = new boolean[board.length][board[0].length];

        if (word.length() == 1) {
            return checkIfCharacterExists(word.charAt(0));
        }

        recursion(0, 0, 0);

        return exists;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'c', 'a', 'a' },
                { 'a', 'a', 'a' },
                { 'b', 'c', 'd' }
        };
        String word = "a";

        System.out.println(new WordSearch().exist(board, word));
    }
}