package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Question12
 */
public class RandomizedSet {

    private Map<Integer, Integer> num2Index;
    private List<Integer> nums;
    private Random random;

    public RandomizedSet() {
        random = new Random();
        num2Index = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (num2Index.containsKey(val)) {
            return false;
        }
        nums.add(val);
        num2Index.put(val, nums.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!num2Index.containsKey(val)) {
            return false;
        }
        int pos = num2Index.get(val);
        if (pos != nums.size() - 1) {
            int lastValue = nums.get(nums.size() - 1);
            num2Index.put(lastValue, pos);
            nums.set(pos, lastValue);
        }
        nums.remove(nums.size() - 1);
        num2Index.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
