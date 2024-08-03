package priv.cxs.classic150;

public class Question87 {

    Integer cur;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (cur != null && root.val <= cur) {
            return false;
        }
        cur = root.val;
        return isValidBST(root.right);
    }
}
