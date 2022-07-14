package basicalgorithm.linkedList.leetcode328;

/**
 * 328. 奇偶链表
 * https://leetcode.cn/problems/odd-even-linked-list/
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode firstCur = first;
        ListNode secondCur = second;

        while (secondCur != null && secondCur.next != null) {
            firstCur.next = secondCur.next;
            firstCur = secondCur.next;

            secondCur.next = firstCur.next;
            secondCur = firstCur.next;
        }
        firstCur.next = second;
        return first;
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
