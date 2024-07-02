package priv.cxs.classic150;

public class Question5 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                value = nums[i];
                count++;
            } else if (nums[i] == value) {
                count++;
            } else {
                count--;
            }
        }

        return value;
    }
}
