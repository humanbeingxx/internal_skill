package priv.cxs.classic150;

import java.util.Arrays;

public class Question4 {

    public int removeDuplicates(int[] nums) {
        int preNum = nums[0];
        int duplicateCount = 1;
        int writePos = 1;
        int count = 1;
        for (int checkPos = 1; checkPos < nums.length; checkPos++) {
            int num = nums[checkPos];
            if (num == preNum) {
                if (duplicateCount < 2) {
                    nums[writePos++] = num;
                    duplicateCount++;
                    count++;
                }
            } else {
                duplicateCount = 1;
                nums[writePos++] = num;
                preNum = num;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = new Question4().removeDuplicates(a);
        System.out.println(result);
        System.out.println(Arrays.toString(a));
    }
}
