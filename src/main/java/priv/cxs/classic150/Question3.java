package priv.cxs.classic150;

import java.util.Arrays;

public class Question3 {

    public int removeDuplicates(int[] nums) {
        int curNum = nums[0];
        int checkPos = 1;
        int writePos = 1;
        int count = 1;
        while (checkPos < nums.length) {
            if (nums[checkPos] == curNum) {
                checkPos++;
            } else {
                curNum = nums[checkPos];
                nums[writePos++] = curNum;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int result = new Question3().removeDuplicates(a);
        System.out.println(result);
        System.out.println(Arrays.toString(a));
    }
}
