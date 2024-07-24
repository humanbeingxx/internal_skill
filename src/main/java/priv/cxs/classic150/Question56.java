package priv.cxs.classic150;

public class Question56 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }
}
