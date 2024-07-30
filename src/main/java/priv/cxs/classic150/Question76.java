package priv.cxs.classic150;

public class Question76 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int preVal) {
        if (root.left == null && root.right == null) {
            sum += (preVal * 10 + root.val);
        }
        if (root.left != null) {
            sumNumbers(root.left, preVal * 10 + root.val);
        }
        if (root.right != null) {
            sumNumbers(root.right, preVal * 10 + root.val);
        }
    }
}
