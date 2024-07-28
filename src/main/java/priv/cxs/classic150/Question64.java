package priv.cxs.classic150;

public class Question64 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head, last = null;
        int len = 0;
        while (node != null) {
            if (node.next == null) {
                last = node;
            }
            node = node.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        node = head;
        for (int i = 0; i < len - k - 1; i++) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        last.next = head;
        return newHead;
    }
}
