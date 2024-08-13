package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.List;

public class Question101 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        rec(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void rec(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                rec(nums, used, temp, result);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
