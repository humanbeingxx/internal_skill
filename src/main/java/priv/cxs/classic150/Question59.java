package priv.cxs.classic150;

import java.util.HashMap;
import java.util.Map;

public class Question59 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node result = new Node(0), newHead = result, oldHead = head;
        Map<Node, Node> old2New = new HashMap<>();
        while (head != null) {
            result.next = new Node(head.val);
            result = result.next;
            old2New.put(head, result);
            head = head.next;
        }
        result = newHead.next;
        head = oldHead;
        while (head != null) {
            result.random = old2New.get(head.random);
            result = result.next;
            head = head.next;
        }
        return newHead.next;
    }
}
