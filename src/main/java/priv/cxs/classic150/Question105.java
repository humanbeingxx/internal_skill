package priv.cxs.classic150;

public class Question105 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] charArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (rec(board, i, j, 1, charArray, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }

            }
        }
        return false;
    }

    private boolean rec(char[][] board, int i, int j, int index, char[] charArray, boolean[][] visited) {
        if (index == charArray.length) {
            return true;
        }
        char needMatch = charArray[index];
        if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == needMatch) {
            visited[i - 1][j] = true;
            if (rec(board, i - 1, j, index + 1, charArray, visited)) {
                return true;
            }
            visited[i - 1][j] = false;
        }
        if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == needMatch) {
            visited[i][j - 1] = true;
            if (rec(board, i, j - 1, index + 1, charArray, visited)) {
                return true;
            }
            visited[i][j - 1] = false;
        }
        if (i < board.length - 1 && !visited[i + 1][j] && board[i + 1][j] == needMatch) {
            visited[i + 1][j] = true;
            if (rec(board, i + 1, j, index + 1, charArray, visited)) {
                return true;
            }
            visited[i + 1][j] = false;
        }
        if (j < board[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == needMatch) {
            visited[i][j + 1] = true;
            if (rec(board, i, j + 1, index + 1, charArray, visited)) {
                return true;
            }
            visited[i][j + 1] = false;
        }
        return false;
    }
}
