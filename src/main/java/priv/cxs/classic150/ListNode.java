package priv.cxs.classic150;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    static ListNode from(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode node = new ListNode(nums[0]);
        ListNode head = node;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return head;
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.val).append(",");
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
