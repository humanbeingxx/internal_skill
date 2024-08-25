package priv.cxs.classic150;

public class Question118 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1) {
            return getKth(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
        } else {
            return (getKth(nums1, nums2, (nums1.length + nums2.length) / 2 - 1)
                    + getKth(nums1, nums2, nums1.length / 2)) / 2.0;
        }
    }

    private int getKth(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int mid = k / 2;
            int pos1 = Math.min(index1 + mid, len1) - 1;
            int pos2 = Math.min(index2 + mid, len2) - 1;
            int value1 = nums1[pos1];
            int value2 = nums1[pos2];
            if (value1 <= value2) {
                k -= (pos1 - index1 + 1);
                index1 += pos1 + 1;
            } else {
                k -= (pos2 - index2 + 1);
                index2 += pos2 + 1;
            }
        }
    }
}
