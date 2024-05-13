package leetcode_top_100.linked_list.lc160;

import basicalgorithm.linkedList.base.ListNode;

import java.util.HashSet;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode head = headA;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            set.add(head);
            head = head.next;
        }
        head = headB;
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
