package basicalgorithm.linkedList.leetcode1171;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
public class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode pre = vHead;
        ListNode cur = head;

        a:
        while (cur.next != null) {
            // 滑动窗口的头cur尾end 开始滑动
            ListNode end = cur.next;
            int total = cur.val;
            b:
            while (end.next != null) {
                total = total + end.val;
                if (total == 0) {
                    break b;
                }
                end = end.next;
            }

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
