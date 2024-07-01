package leetcode_top_100.linked_list.lc25;

import categorized.linkedList.base.ListNode;
import categorized.linkedList.base.ListNodeUtil;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.genListNode(new int[]{1, 2, 3, 4, 5});
        new Solution().reverseKGroup(head, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        A:
        while (cur != null) {
            ListNode tail = cur;
            for (int i = 0; i < k - 1; i++) {
                if (tail.next != null) {
                    tail = tail.next;
                } else {
                    break A;
                }
            }
            ListNode tailNext = tail.next;
            ListNode[] ans = reverseListNode(cur, tail);
            ListNode newHead = ans[0];
            ListNode newTail = ans[1];
            pre.next = newHead;
            newTail.next = tailNext;

            pre = newTail;
            cur = tailNext;
        }
        return dummy.next;
    }

    private ListNode[] reverseListNode(ListNode head, ListNode tail) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

}
