package priv.cxs.classic150;

import java.util.HashMap;
import java.util.Map;

public class Question45 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer pos = index.get(num);
            if (pos != null && i - pos <= k) {
                return true;
            }
            index.put(num, i);
        }
        return false;
    }
}
