package priv.cxs.classic150;

public class Question113 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0, down = matrix.length;
        while (up < down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                up = mid + 1;
            } else {
                down = mid;
            }
        }
        if (down == 0) {
            return false;
        }
        int row = down - 1;
        int left = 0, right = matrix[row].length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}
