package priv.cxs.classic150;

public class Question37 {

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                if (i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -2)) {
                    liveCount++;
                }
                if (i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -2)) {
                    liveCount++;
                }
                if (i - 1 >= 0 && j + 1 < n && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -2)) {
                    liveCount++;
                }
                if (j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -2)) {
                    liveCount++;
                }
                if (j + 1 < n && (board[i][j + 1] == 1 || board[i][j + 1] == -2)) {
                    liveCount++;
                }
                if (i + 1 < m && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -2)) {
                    liveCount++;
                }
                if (i + 1 < m && (board[i + 1][j] == 1 || board[i + 1][j] == -2)) {
                    liveCount++;
                }
                if (i + 1 < m && j + 1 < n && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -2)) {
                    liveCount++;
                }
                int current = board[i][j];
                if (current == 1) {
                    if (liveCount < 2 || liveCount > 3) {
                        board[i][j] = -2;
                    }
                } else {
                    if (liveCount == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
