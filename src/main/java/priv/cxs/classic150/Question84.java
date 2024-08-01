package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question84 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean left2Right = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (left2Right) {
                    node = deque.pollLast();
                } else {
                    node = deque.poll();
                }
                level.add(node.val);
                if (left2Right) {
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }

                } else {
                    if (node.right != null) {
                        deque.add(node.right);
                    }
                    if (node.left != null) {
                        deque.add(node.left);
                    }
                }
            }
            result.add(level);
            left2Right = !left2Right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        new Question84().zigzagLevelOrder(root);
    }
}
