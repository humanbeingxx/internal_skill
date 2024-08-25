package priv.cxs.classic150;

public class Question117 {

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int low = 0, high = nums.length, mid = low + (high - low) / 2;
        while (low < high) {
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else {
                if (nums[mid] >= nums[0]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
                mid = low + (high - low) / 2;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(new Question117().findMin(new int[]{1,2,3,4}));
    }
}
