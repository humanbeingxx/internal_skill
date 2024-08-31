package priv.cxs.classic150;

public class Question139 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        int len = 1;
        dp[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                len++;
                dp[len] = nums[i];
            } else {
                int left = 1, right = len;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (dp[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[left] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Question139().lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
