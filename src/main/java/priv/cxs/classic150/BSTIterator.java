package priv.cxs.classic150;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        if (pop.right != null) {
            TreeNode node = pop.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
