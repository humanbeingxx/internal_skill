package priv.cxs.classic150;

public class Question85 {

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        rec(root);
        return min;
    }

    private void rec(TreeNode root) {
        if (root == null) {
            return;
        }
        rec(root.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(root.val - pre.val));
        }
        pre = root;
        rec(root.right);
    }
}
