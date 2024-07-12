package priv.cxs.classic150;

public class Question28 {

    public int maxArea(int[] height) {
        int length = height.length;
        int maxV = 0;
        int left = 0, right = length - 1;
        while (left < right) {
            int v = Math.min(height[left], height[right]) * (right - left);
            maxV = Math.max(v, maxV);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxV;
    }

}
