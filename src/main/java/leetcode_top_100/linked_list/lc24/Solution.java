package leetcode_top_100.linked_list.lc24;

import categorized.linkedList.base.ListNode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode cur = vHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = temp.next.next;
            cur.next.next = temp;
            cur = temp;
        }
        return vHead.next;
    }
}
