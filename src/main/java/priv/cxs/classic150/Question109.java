package priv.cxs.classic150;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question109 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode dummy = new ListNode(0), node = dummy;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            node.next = poll;
            node = node.next;
            if (poll.next != null) {
                queue.add(poll.next);
            }
        }
        return dummy.next;
    }
}
