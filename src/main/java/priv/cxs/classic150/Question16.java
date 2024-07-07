package priv.cxs.classic150;

public class Question16 {

    public int trap(int[] height) {
        int length = height.length;
        int[] maxLeft = new int[length];
        maxLeft[0] = height[0];
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        int[] maxRight = new int[length];
        maxRight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return count;
    }
}
