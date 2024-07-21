package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question48 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
            if (i == intervals.length - 1) {
                result.add(current);
            }
        }
        return result.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        int[][] result = new Question48().merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
