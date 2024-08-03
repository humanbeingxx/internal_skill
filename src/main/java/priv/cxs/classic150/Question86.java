package priv.cxs.classic150;

public class Question86 {

    int count = 0;
    int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        rec(root, k);
        return val;
    }

    private void rec(TreeNode root, int k) {
        if (count == k) {
            val = root.val;
            return;
        }
        if (root.left != null) {
            kthSmallest(root.left, k);
        }
        count++;
        if (count == k) {
            val = root.val;
            return;
        }
        if (root.right != null) {
            kthSmallest(root.right, k);
        }
    }
}
