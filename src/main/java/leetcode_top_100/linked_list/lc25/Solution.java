package leetcode_top_100.linked_list.lc25;

import basicalgorithm.linkedList.base.ListNode;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

    }

    private void reverse(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
