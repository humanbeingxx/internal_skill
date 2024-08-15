package priv.cxs.classic150;

public class Question110 {

    public int maxSubArray(int[] nums) {
        int start = 0;
        int max = nums[0], current = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        while (start < nums.length) {
            while (start < nums.length && nums[start] <= 0) {
                start++;
            }
            int end = start;
            while (end < nums.length && current + nums[end] >= 0) {
                current += nums[end];
                end++;
                max = Math.max(max, current);
            }
            current = 0;
            start = end + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        new Question110().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
