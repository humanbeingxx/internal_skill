package priv.cxs.classic150;

public class Question58 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode(0), head = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            result = result.next;
        }
        while (list1 != null) {
            result.next = new ListNode(list1.val);
            list1 = list1.next;
            result = result.next;
        }
        while (list2 != null) {
            result.next = new ListNode(list2.val);
            list2 = list2.next;
            result = result.next;
        }

        return head.next;
    }
}
