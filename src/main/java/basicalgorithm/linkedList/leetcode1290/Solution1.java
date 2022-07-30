package basicalgorithm.linkedList.leetcode1290;

import basicalgorithm.linkedList.base.ListNode;

/**
 * 1290. 二进制链表转整数
 * https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/
 * todo review
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(1 << 2);
    }

    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode cur = head;
        while (cur != null) {
            result = (result << 1) + cur.val;
            cur = cur.next;
        }
        return result;
    }

    public int getDecimalValue2(ListNode head) {
        int result = 0;
        ListNode cur = head;
        while (cur != null) {
            result = result * 2 + cur.val;
            cur = cur.next;
        }
        return result;
    }
}
