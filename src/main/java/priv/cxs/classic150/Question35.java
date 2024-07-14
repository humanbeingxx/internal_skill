package priv.cxs.classic150;

import java.util.Arrays;

public class Question35 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int level = 0; level < (n + 1) / 2; level++) {
            for (int i = level; i < n - level - 1; i++) {
                // level, i  -->  i, n - 1 - level
                // i, n - 1 - level --> n - 1 - level, n - 1 - i
                // n - 1 - level, n - 1 - i --> n - 1 - i, level
                // n - 1 - i, level --> level, i
                int temp = matrix[level][i];
                matrix[level][i] = matrix[n - 1 - i][level];
                matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i];
                matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level];
                matrix[i][n - 1 - level] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        new Question35().rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
            ;
        }
    }
}
