package priv.cxs.classic150;

public class Question119 {

    public int findKthLargest(int[] nums, int k) {
        return quick(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quick(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start, right = end;
        int partition = nums[start];
        while (left < right) {
            while (right > left && nums[right] >= partition) {
                right--;
            }
            while (left < right && nums[left] < partition) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            } else {
                break;
            }
        }
        if (right >= k) {
            return quick(nums, start, right, k);
        } else {
            return quick(nums, right + 1, end, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question119().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
