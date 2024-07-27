package priv.cxs.classic150;

public class Question63 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode pre = guard, node = head;
        while (node != null) {
            if (node.next == null) {
                break;
            }
            if (node.next.val == node.val) {
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }
                pre.next = node.next;
                node = node.next;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return guard.next;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.from(new int[]{1,1,1,1,2,3,3,4,4,5});
        System.out.println(new Question63().deleteDuplicates(list));
    }
}
