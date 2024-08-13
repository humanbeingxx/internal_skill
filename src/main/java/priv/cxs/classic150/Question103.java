package priv.cxs.classic150;

import java.util.HashSet;
import java.util.Set;

public class Question103 {

    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> toRight = new HashSet<>();
        Set<Integer> toLeft = new HashSet<>();
        return rec(n, 0, columns, toRight, toLeft);
    }

    private int rec(int n, int row, Set<Integer> columns, Set<Integer> toRight, Set<Integer> toLeft) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int right = row - i;
            if (toRight.contains(right)) {
                continue;
            }
            int left = row + i;
            if (toLeft.contains(left)) {
                continue;
            }
            columns.add(i);
            toRight.add(right);
            toLeft.add(left);
            count += rec(n, row + 1, columns, toRight, toLeft);
            columns.remove(i);
            toRight.remove(right);
            toLeft.remove(left);
        }
        return count;
    }
}


