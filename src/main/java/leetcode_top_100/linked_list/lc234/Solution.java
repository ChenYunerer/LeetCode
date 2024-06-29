package leetcode_top_100.linked_list.lc234;

import categorized.linkedList.base.ListNode;

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode half = endOfFirstHalf(head);
        ListNode reverseListHead = reverseList(half.next);
        ListNode a = head;
        ListNode b = reverseListHead;
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        // recover ListNode
        reverseListHead.next = reverseList(reverseListHead);
        return true;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
