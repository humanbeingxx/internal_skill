package priv.cxs.classic150;

import java.util.HashMap;
import java.util.Map;

public class Question43 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            Integer pos = index.get(left);
            if (pos != null && pos != i) {
                return new int[]{i, pos};
            }
        }
        return null;
    }
}
