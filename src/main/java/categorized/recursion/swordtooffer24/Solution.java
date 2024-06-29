package categorized.recursion.swordtooffer24;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author yunyu.cy
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
