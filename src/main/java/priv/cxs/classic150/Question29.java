package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question29 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                if (nums[second] + nums[third] == target) {
                    List<Integer> values = new ArrayList<>();
                    values.add(nums[first]);
                    values.add(nums[second]);
                    values.add(nums[third]);
                    result.add(values);
                    second++;
                    third--;
                } else if (nums[second] + nums[third] < target) {
                    second++;
                } else {
                    third--;
                }
                while (second > first + 1 && second < third && nums[second] == nums[second - 1]) {
                    second++;
                }
                while (third < nums.length - 2 && second < third && nums[third] == nums[third + 1]) {
                    third--;
                }
                if (second >= third) {
                    break;
                }

            }
        }
        return result;
    }
}
