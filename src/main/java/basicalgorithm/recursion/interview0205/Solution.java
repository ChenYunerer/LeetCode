package basicalgorithm.recursion.interview0205;

import basicalgorithm.linkedList.base.ListNode;

/**
 * 面试题 02.05. 链表求和
 * https://leetcode.cn/problems/sum-lists-lcci/
 */
public class Solution {
    int carry = 0;

    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     * <p>
     * 这些数位是反向存放的，也就是个位排在链表首部。
     * <p>
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * <p>
     * 示例：
     * <p>
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int total = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        int val = total % 10;
        carry = total / 10;
        ListNode nextNode = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        ListNode currentListNode = new ListNode();
        currentListNode.val = val;
        currentListNode.next = nextNode;
        return currentListNode;
    }

    /**
     * 思考一下，假设这些数位是正向存放的，又该如何解决呢?
     * 示例：
     * <p>
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     * <p>
     * <p>
     * 反转链表后处理完再反转回来
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return null;
    }
}
