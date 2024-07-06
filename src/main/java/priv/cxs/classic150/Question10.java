package priv.cxs.classic150;

public class Question10 {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 1;
        int mostFar = nums[0];
        int pos = 0;
        while (mostFar < nums.length - 1) {
            count++;
            int nextPos = pos;
            for (int i = pos + 1; i <= pos + nums[pos]; i++) {
                if (i + nums[i] > mostFar) {
                    mostFar = i + nums[i];
                    nextPos = i;
                }
                if (mostFar >= nums.length - 1) {
                    break;
                }
            }
            pos = nextPos;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        int result = new Question10().jump(a);
        System.out.println(result);
    }
}
