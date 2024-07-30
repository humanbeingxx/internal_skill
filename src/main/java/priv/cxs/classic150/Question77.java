package priv.cxs.classic150;

public class Question77 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int rootMax = pathSum(root);
        return Math.max(max, rootMax);
    }

    private int pathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        }
        int maxVal = root.val, leftMax = 0, rightMax = 0;
        if (root.left != null) {
            leftMax = pathSum(root.left);
        }
        if (root.right != null) {
            rightMax = pathSum(root.right);
        }
        if (leftMax > 0) {
            maxVal += leftMax;
        }
        if (rightMax > 0) {
            maxVal += rightMax;
        }
        max = Math.max(max, maxVal);
        return Math.max(root.val, Math.max(root.val + leftMax, root.val + rightMax));
    }
}
