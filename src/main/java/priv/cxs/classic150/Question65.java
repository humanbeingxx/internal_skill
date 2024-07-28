package priv.cxs.classic150;

public class Question65 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0), smallHead = small;
        ListNode big = new ListNode(0), bigHead = big;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                small.next = node;
                small = small.next;
            } else {
                big.next = node;
                big = big.next;
            }
            node = node.next;
        }
        small.next = bigHead.next;
        big.next = null;
        return smallHead.next;
    }
}
