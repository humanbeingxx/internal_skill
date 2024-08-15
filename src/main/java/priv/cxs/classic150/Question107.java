package priv.cxs.classic150;

public class Question107 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        ListNode guard = new ListNode(0);
        guard.next = head;
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            ListNode curr = guard.next;
            ListNode pre = guard;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                if (curr != null) {
                    for (int i = 1; i < subLen && curr.next != null; i++) {
                        curr = curr.next;
                    }
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                pre.next = merge(head1, head2);
                while (pre.next != null) {
                    pre = pre.next;
                }
                curr = next;
            }
        }
        return guard.next;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode node1 = head1, node2 = head2, node = head;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        } else if (node2 != null) {
            node.next = node2;
        }
        return head.next;
    }
}
