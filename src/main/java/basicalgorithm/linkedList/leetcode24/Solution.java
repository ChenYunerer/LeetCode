package basicalgorithm.linkedList.leetcode24;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * @author yunyu.cy
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode pre = vHead;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            cur.next = temp;

            pre = cur;
            cur = cur.next;
        }
        return vHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
