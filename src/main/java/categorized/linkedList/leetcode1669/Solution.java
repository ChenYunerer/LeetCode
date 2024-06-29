package categorized.linkedList.leetcode1669;

import categorized.linkedList.base.ListNode;

/**
 * 1669. 合并两个链表
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 *
 * @author yunyu.cy
 */
public class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        int index = 0;
        while (index < a - 1) {
            cur = cur.next;
            index++;
        }
        ListNode deletePreNode = cur;

        while (index < b) {
            cur = cur.next;
            index++;
        }

        deletePreNode.next = list2;

        ListNode l2Cur = list2;
        while (l2Cur.next != null) {
            l2Cur = l2Cur.next;
        }

        l2Cur.next = cur.next;
        return list1;
    }
}
