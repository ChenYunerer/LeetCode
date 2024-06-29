package categorized.linkedList.leetcode1290;

import categorized.linkedList.base.ListNode;

import java.util.Stack;

/**
 * 1290. 二进制链表转整数
 * https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class Solution {

    public int getDecimalValue(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int result = 0;
        int i = 0;
        while (stack.size() != 0) {
            result = result + stack.pop() * (int) Math.pow(2, i);
            i++;
        }
        return result;
    }
}
