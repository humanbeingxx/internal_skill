package priv.cxs.classic150;

public class Question15 {

    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 1;
        int count = 0;
        for(int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            count += Math.max(right, left[i]);
        }
        return count;
    }
}
