package leetcode_top_100.linked_list.lc2;

import categorized.linkedList.base.ListNode;

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode vHead = new ListNode();
        ListNode cur = vHead;
        int overflow = 0;
        while (l1 != null || l2 != null) {
            int sum = overflow + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            cur.next = new ListNode(sum % 10);
            overflow = sum / 10;
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (overflow > 0) {
            cur.next = new ListNode(overflow);
        }
        return vHead.next;
    }
}
