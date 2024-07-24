package priv.cxs.classic150;

public class Question57 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + carry;
            int val = num;
            if (num >= 10) {
                val = num - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.next = new ListNode(val);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int num = l1.val + carry;
            int val = num;
            if (num >= 10) {
                val = num - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.next = new ListNode(val);
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int num = l2.val + carry;
            int val = num;
            if (num >= 10) {
                val = num - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.next = new ListNode(val);
            result = result.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            result.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.from(new int[]{2, 4, 3});
        ListNode node2 = ListNode.from(new int[]{5, 6, 4});
        ListNode result = new Question57().addTwoNumbers(node1, node2);
        System.out.println(result);
    }
}
