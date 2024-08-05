package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Question92 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[1]]++;
        }
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!preMap.containsKey(prerequisite[0])) {
                preMap.put(prerequisite[0], new ArrayList<>());
            }
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            numCourses--;
            Integer poll = queue.poll();
            List<Integer> nexts = preMap.get(poll);
            if (nexts != null) {
                for (Integer next : nexts) {
                    degrees[next]--;
                    if (degrees[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        return numCourses == 0;
    }


    public static void main(String[] args) {
        new Question92().canFinish(2, new int[][]{{1, 0}, {0, 1}});
    }
}
