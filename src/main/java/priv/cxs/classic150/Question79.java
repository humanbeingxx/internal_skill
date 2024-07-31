package priv.cxs.classic150;

public class Question79 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            level++;
        }
        int low = 1 << level;
        int high = (1 << (level+1)) - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean exists(TreeNode node, int level, int mid) {
        int bits = 1 << (level - 1);
        while (node != null && bits > 0) {
            if ((mid & bits) == 1) {
                node = node.right;
            } else {
                node = node.left;
            }
            bits >>= 1;
        }
        return node != null;
    }

}
