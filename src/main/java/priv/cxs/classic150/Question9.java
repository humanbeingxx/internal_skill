package priv.cxs.classic150;

public class Question9 {

    public boolean canJump(int[] nums) {
        int mostFar = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= mostFar) {
                mostFar = Math.max(mostFar, i + nums[i]);
                if (mostFar >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
