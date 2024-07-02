package priv.cxs.classic150;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class Question1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int writePos = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[writePos--] = nums1[index1--];
            } else {
                nums1[writePos--] = nums2[index2--];
            }
        }
        while (index1 >= 0) {
            nums1[writePos--] = nums1[index1--];
        }
        while (index2 >= 0) {
            nums1[writePos--] = nums2[index2--];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        new Question1().merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }
}
