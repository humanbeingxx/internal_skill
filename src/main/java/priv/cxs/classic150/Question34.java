package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.List;

public class Question34 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0, j = 0; i < (m + 1) / 2 && j < (n + 1) / 2; i++, j++) {
            round(matrix, i, j, result);
        }
        return result;
    }

    private void round(int[][] matrix, int startI, int startJ, List<Integer> result) {
        int m = matrix.length, n = matrix[0].length;
        boolean go = false;
        // right
        for (int i = startJ; i < n - startJ; i++) {
            go = true;
            result.add(matrix[startI][i]);
        }
        // down
        if (!go) {
            return;
        }
        go = false;
        if (n - startJ - 1 >= 0) {
            for (int i = startI + 1; i < m - startI; i++) {
                go = true;
                result.add(matrix[i][n - startJ - 1]);
            }
        }
        // left
        if (!go) {
            return;
        }
        go = false;
        if (m - startI - 1 >= 0 && n - startJ - 2 >= 0) {
            for (int i = n - startJ - 2; i >= startJ; i--) {
                go = true;
                result.add(matrix[m - startI - 1][i]);
            }
        }
        // up
        if (!go) {
            return;
        }
        if (m - startI - 2 >= 0) {
            for (int i = m - startI - 2; i > startI; i--) {
                result.add(matrix[i][startJ]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 5, 8}, {4, 0, -1}
        };
        List<Integer> result = new Question34().spiralOrder(matrix);
        System.out.println(result);
    }
}
