package basicalgorithm.linkedList.leetcode25;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode pre = vHead;
        ListNode cur = vHead.next;
        while (cur != null) {
            ListNode pre1 = pre;
            ListNode cur1 = cur;
            int i = 1;
            while ()

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
