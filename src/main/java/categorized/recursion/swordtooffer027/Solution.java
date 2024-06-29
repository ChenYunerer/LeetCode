package categorized.recursion.swordtooffer027;

/**
 * 剑指 Offer II 027. 回文链表
 * https://leetcode.cn/problems/aMhZSa/
 */
public class Solution {

    private ListNode cur;

    private boolean doIsPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean isPalindrome = doIsPalindrome(head.next);
        if (!isPalindrome) {
            return false;
        }
        if (head.val != cur.val) {
            return false;
        } else {
            cur = cur.next;
            return true;
        }
    }

    public boolean isPalindrome(ListNode head) {
        cur = head;
        return doIsPalindrome(head);
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
