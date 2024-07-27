package priv.cxs.classic150;

public class Question61 {

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (len == 1 || k == 1) {
            return head;
        }
        int turn = len / k;
        for (int i = 0; i < turn; i++) {
            head = new Part().reverseBetween(head, i * k + 1, (i + 1) * k);
        }
        return head;
    }

    private class Part {
        ListNode first, last, leftOfIndex, rightOfIndex;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head.next == null || left == right) {
                return head;
            }
            ListNode guard = new ListNode(0);
            guard.next = head;

            ListNode node = guard;
            int index = 1;
            while (index < left) {
                node = node.next;
                index++;
            }
            leftOfIndex = node;
            first = rec(node.next, index, right);
            first.next = rightOfIndex;
            leftOfIndex.next = last;
            return guard.next;
        }

        private ListNode rec(ListNode node, int index, int right) {
            if (index > right) {
                return null;
            } else if (index == right) {
                last = node;
                rightOfIndex = node.next;
            }
            index++;
            ListNode next = rec(node.next, index, right);
            if (next != null) {
                next.next = node;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode list = ListNode.from(new int[]{1, 2, 3, 4, 5});
        ListNode result = new Question61().reverseKGroup(list, 3);
        System.out.println(result.toString());
    }
}
