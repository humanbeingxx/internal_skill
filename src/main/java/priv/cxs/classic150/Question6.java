package priv.cxs.classic150;

import java.util.Arrays;

public class Question6 {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }
        int moveCount = 0;
        int start = 0;
        while (moveCount < nums.length) {
            int pos = start;
            int preNum = nums[pos];
            do {
                pos = (pos + k) % nums.length;
                int temp = nums[pos];
                nums[pos] = preNum;
                preNum = temp;
                moveCount++;
            } while (pos != start);
            start++;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        new Question6().rotate(a, 4);
        System.out.println(Arrays.toString(a));
    }
}
