package priv.cxs.classic150;

public class Question27 {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int sum = numbers[start] + numbers[end];
        while (start < end) {
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                sum = sum + numbers[end - 1] - numbers[end];
                end--;
            } else {
                sum = sum + numbers[start + 1] - numbers[start];
                start++;
            }
        }
        return null;
    }
}
