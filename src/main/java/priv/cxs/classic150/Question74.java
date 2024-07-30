package priv.cxs.classic150;

public class Question74 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode rightOfLeft = root.left;
        if (rightOfLeft != null) {
            while (rightOfLeft.right != null) {
                rightOfLeft = rightOfLeft.right;
            }
            rightOfLeft.right = root.right;
            root.right = root.left;
        }
        root.left = null;
    }

}
