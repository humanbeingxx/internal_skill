package priv.cxs.classic150;

public class Question72 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inPos = findPos(inorder, inStart, inEnd, rootVal);
        int len = inPos - inStart;
        root.left = buildTree(inorder, inStart, inPos - 1, postorder, postStart, postStart + len - 1);
        root.right = buildTree(inorder, inPos + 1, inEnd,  postorder, postStart + len, postEnd - 1);
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

    public static void main(String[] args) {
        TreeNode result = new Question72().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
