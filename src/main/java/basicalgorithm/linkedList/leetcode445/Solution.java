package basicalgorithm.linkedList.leetcode445;

/**
 * 445. 两数相加 II
 * <p>
 * https://leetcode.cn/problems/add-two-numbers-ii/
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Revert = revertListNode(l1);
        ListNode l2Revert = revertListNode(l2);
        ListNode vHead = new ListNode();
        ListNode fixedVHead = vHead;
        ListNode l1Cur = l1Revert;
        ListNode l2Cur = l2Revert;
        int step = 0;
        while (l1Cur != null || l2Cur != null || step != 0) {
            ListNode node = new ListNode();
            int val = (l1Cur == null ? 0 : l1Cur.val) + (l2Cur == null ? 0 : l2Cur.val) + step;
            if (val >= 10) {
                val = val - 10;
                step = 1;
            } else {
                step = 0;
            }
            node.val = val;
            vHead.next = node;
            vHead = node;
            l1Cur = l1Cur == null ? null : l1Cur.next;
            l2Cur = l2Cur == null ? null : l2Cur.next;
        }
        return revertListNode(fixedVHead.next);
    }

    public ListNode revertListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
