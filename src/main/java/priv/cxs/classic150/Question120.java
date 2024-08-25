package priv.cxs.classic150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Question120 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] sorted = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            sorted[i][0] = profits[i];
            sorted[i][1] = capital[i];
        }
        Arrays.sort(sorted, Comparator.comparingInt(o -> o[1]));
        int usedIndex = 0;
        PriorityQueue<Integer> candidates = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int total = w;
        for (int i = 0; i < k; i++) {
            while (usedIndex < sorted.length) {
                if (sorted[usedIndex][1] <= total) {
                    candidates.offer(sorted[usedIndex][0]);
                    usedIndex++;
                } else {
                    break;
                }
            }
            if (candidates.isEmpty()) {
                return total;
            }
            total += candidates.poll();
        }
        return total;
    }
}
