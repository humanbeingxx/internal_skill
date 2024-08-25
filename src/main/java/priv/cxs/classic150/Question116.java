package priv.cxs.classic150;

public class Question116 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{searchFirst(nums, target), searchLast(nums, target)};
    }

    private int searchFirst(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start == nums.length) {
            return  -1;
        }
        return nums[start] == target ? start : -1;
    }

    private int searchLast(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start == 0) {
            return nums[0] == target ? 0 : -1;
        }
        return nums[start - 1] == target ? start - 1 : -1;
    }
}
