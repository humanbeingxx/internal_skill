package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question73 {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> next = new ArrayList<>();
            Node pre = queue.poll();
            if (pre.left != null) {
                next.add(pre.left);
            }
            if (pre.right != null) {
                next.add(pre.right);
            }
            for (Node node : queue) {
                pre.next = node;
                pre = node;
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            pre.next = null;
            queue.clear();
            queue.addAll(next);
        }
        return root;
    }
}
