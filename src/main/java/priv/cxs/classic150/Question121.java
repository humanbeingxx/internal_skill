package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Question121 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
        for (int i = 0; i < nums1.length; i++) {
            priorityQueue.add(new int[]{nums1[i], nums2[0], i, 0});
        }
        List<List<Integer>> result = new ArrayList<>();
        while (result.size() < k && !priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            result.add(asList(poll[0], poll[1]));
            if (poll[3] < nums2.length - 1) {
                priorityQueue.add(new int[]{poll[0], nums2[poll[3] + 1], poll[2], poll[3] + 1});
            }
        }
        return result;
    }

    private List<Integer> asList(int... nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            result.add(num);
        }
        return result;
    }
}
