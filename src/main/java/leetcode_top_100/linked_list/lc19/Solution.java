package leetcode_top_100.linked_list.lc19;

import basicalgorithm.linkedList.base.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode fast = vHead;
        ListNode slow = vHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next == null ? null : slow.next.next;
        return vHead.next;
    }
}
