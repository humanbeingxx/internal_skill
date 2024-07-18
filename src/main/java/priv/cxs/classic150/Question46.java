package priv.cxs.classic150;

import java.util.HashSet;
import java.util.Set;

public class Question46 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int next = num + 1;
            int len = 1;
            while (numSet.contains(next)) {
                next++;
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }

}
