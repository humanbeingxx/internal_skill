package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.List;

public class Question102 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        rec(candidates, target, new ArrayList<>(), 0, 0, result);
        return result;
    }

    private void rec(int[] candidates, int target, List<Integer> temp, int index, int sum, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                temp.add(candidates[i]);
                rec(candidates, target, temp, i,sum + candidates[i], result);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
