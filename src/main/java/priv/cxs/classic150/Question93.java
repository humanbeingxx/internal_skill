package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Question93 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
        }
        int[] result = new int[numCourses];
        Arrays.fill(result, -1);
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!preMap.containsKey(prerequisite[1])) {
                preMap.put(prerequisite[1], new ArrayList<>());
            }
            preMap.get(prerequisite[1]).add(prerequisite[0]);
        }
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                result[index++] = i;
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> nexts = preMap.get(poll);
            if (nexts != null) {
                for (Integer next : nexts) {
                    degrees[next]--;
                    if (degrees[next] == 0) {
                        queue.add(next);
                        result[index++] = next;
                    }
                }
            }
        }
        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
