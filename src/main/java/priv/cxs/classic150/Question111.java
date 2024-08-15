package priv.cxs.classic150;

public class Question111 {
    public int maxSubarraySumCircular(int[] nums) {
        int length = nums.length;
        int[] leftMax = new int[length];
        leftMax[0] = nums[0];
        int sum = nums[0];
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
            sum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], sum);
        }

        int rightSum = 0;
        for (int i = length - 1; i > 0; i--) {
            rightSum += nums[i];
            max = Math.max(max, rightSum + leftMax[i - 1]);
        }
        return max;
    }

}
