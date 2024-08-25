package priv.cxs.classic150;

public class Question114 {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return  -1;
    }
}
