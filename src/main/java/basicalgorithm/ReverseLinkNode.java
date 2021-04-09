package basicalgorithm;

/**
 * 反转链表
 */
public class ReverseLinkNode {

    public static ListNode reverseLinkNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    static class ListNode {
        int value;
        ListNode next;
    }
}
