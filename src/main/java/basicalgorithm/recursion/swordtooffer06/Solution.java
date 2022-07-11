package basicalgorithm.recursion.swordtooffer06;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        int[] i = reversePrint(head.next);
        int[] result = new int[i.length + 1];
        for (int index = 0; index < i.length; index++) {
            result[index] = i[index];
        }
        result[result.length - 1] = head.val;
        return result;
    }

    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while (stack.size() != 0) {
            result[index] = stack.pop();
            index++;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
