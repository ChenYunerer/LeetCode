package leetcode_top_100.linked_list.lc141;

import categorized.linkedList.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
