package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question49 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> result = new ArrayList<>();
        int from = 0, to = intervals.length - 1;
        while (from <= to && intervals[from][1] < newInterval[0]) {
            result.add(intervals[from]);
            from++;
        }
        if (from == intervals.length) {
            result.add(newInterval);
            return result.toArray(new int[0][2]);
        } else {
            newInterval[0] = Math.min(newInterval[0], intervals[from][0]);
        }
        while (from <= to && intervals[to][0] > newInterval[1]) {
            to--;
        }
        if (to < from) {
            result.add(newInterval);
        } else {
            newInterval[1] = Math.max(newInterval[1], intervals[to][1]);
            result.add(newInterval);
        }
        for (int i = to + 1; i < intervals.length; i++) {
            result.add(intervals[i]);
        }
        return result.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        int[][] result = new Question49().insert(new int[][]{
                {9, 10}
        }, new int[]{6, 8});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
