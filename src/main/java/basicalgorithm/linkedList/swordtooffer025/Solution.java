package basicalgorithm.linkedList.swordtooffer025;

import basicalgorithm.linkedList.base.ListNode;
import basicalgorithm.linkedList.base.ListNodeUtil;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 * https://leetcode.cn/problems/lMSNwu/
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNodeUtil.genListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNodeUtil.genListNode(new int[]{5, 6, 4});
        ListNode result = solution.addTwoNumbers(l1, l2);
        ListNodeUtil.printLinkNode(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverseListNode(l1);
        ListNode reverseL2 = reverseListNode(l2);

        ListNode reverseL1Cur = reverseL1;
        ListNode reverseL2Cur = reverseL2;
        int step = 0;
        ListNode result = new ListNode();
        ListNode resultCur = result;
        while (reverseL1Cur != null || reverseL2Cur != null || step != 0) {
            int total = (reverseL1Cur != null ? reverseL1Cur.val : 0) +
                    (reverseL2Cur != null ? reverseL2Cur.val : 0) +
                    step;
            int val = total % 10;
            step = total / 10;

            ListNode node = new ListNode();
            node.val = val;
            resultCur.next = node;

            resultCur = node;
            reverseL1Cur = reverseL1Cur != null ? reverseL1Cur.next : reverseL1Cur;
            reverseL2Cur = reverseL2Cur != null ? reverseL2Cur.next : reverseL2Cur;
        }
        return reverseListNode(result.next);
    }

    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

}
