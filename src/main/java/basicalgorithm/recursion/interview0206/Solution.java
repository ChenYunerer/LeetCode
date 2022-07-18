package basicalgorithm.recursion.interview0206;

/**
 * 面试题 02.06. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list-lcci/
 */
public class Solution {
    private ListNode cur;

    private boolean doIsPalindrome(ListNode head) {
        if (head != null) {
            boolean isPalindrome = doIsPalindrome(head.next);
            if (!isPalindrome) {
                return false;
            }
            if (cur.val != head.val) {
                return false;
            } else {
                cur = cur.next;
                return true;
            }
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        cur = head;
        return doIsPalindrome(head);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
