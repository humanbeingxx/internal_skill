package priv.cxs.classic150;

public class Question71 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inPos = findPos(inorder, inStart, inEnd, rootVal);
        int len = inPos - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, inPos - 1);
        root.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, inPos + 1, inEnd);
        return root;
    }

    private int findPos(int[] ints, int from, int to, int val) {
        for (int i = from; i <= to; i++) {
            if (ints[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
