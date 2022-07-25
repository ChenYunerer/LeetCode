package basicalgorithm.linkedList.swordtooffer022;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 022. 链表中环的入口节点
 * https://leetcode.cn/problems/c32eOV/
 */
public class Solution {


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            if (list.contains(cur)) {
                return cur;
            }
            list.add(cur);
            cur = cur.next;
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
