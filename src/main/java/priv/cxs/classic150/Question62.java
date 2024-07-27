package priv.cxs.classic150;

public class Question62 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode left = head, pre = guard, right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            pre = left;
            left = left.next;
        }
        pre.next = left.next;
        return guard.next;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.from(new int[]{1, 2, 3, 4, 5});
        ListNode result = new Question62().removeNthFromEnd(list, 5);
        System.out.println(result);
    }
}
