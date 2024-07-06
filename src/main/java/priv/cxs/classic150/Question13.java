package priv.cxs.classic150;

import java.util.Arrays;

public class Question13 {

    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i];
        }
        int[] result = new int[nums.length];
        int curVal = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            result[i] = curVal * prefixProduct[i - 1];
            curVal *= nums[i];
        }
        result[0] = curVal;
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] result = new Question13().productExceptSelf(a);
        System.out.println(Arrays.toString(result));
    }
}
