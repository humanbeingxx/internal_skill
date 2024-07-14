package priv.cxs.classic150;

import java.util.Arrays;

public class Question33 {

    public boolean isValidSudoku(char[][] board) {
        boolean[] exist = new boolean[10];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(exist, false);
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    c -= '0';
                    if (exist[c]) {
                        return false;
                    }
                    exist[c] = true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Arrays.fill(exist, false);
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    c -= '0';
                    if (exist[c]) {
                        return false;
                    }
                    exist[c] = true;
                }

            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(exist, false);
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i + k][j + l];
                        if (c != '.') {
                            c -= '0';
                            if (exist[c]) {
                                return false;
                            }
                            exist[c] = true;
                        }
                    }
                }

            }
        }

        return true;
    }
}
