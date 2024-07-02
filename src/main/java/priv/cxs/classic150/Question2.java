package priv.cxs.classic150;

import java.util.Arrays;

public class Question2 {

    public int removeElement(int[] nums, int val) {
        int end = nums.length - 1;
        int start = 0;
        int count = 0;
        while (start <= end) {
            if (nums[start] != val) {
                count++;
            } else {
                while (nums[end] == val && start < end) {
                    end--;
                }
                if (start == end) {
                    break;
                }
                count++;
                nums[start] = nums[end];
                end--;
            }
            start++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1};
        int result = new Question2().removeElement(a, 2);
        System.out.println(result);
        System.out.println(Arrays.toString(a));
    }
}
