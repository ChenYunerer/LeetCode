package leetcode_top_100.linked_list.lc23;

import basicalgorithm.linkedList.base.ListNode;

/**
 * 23. 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (true) {
            ListNode min = null;
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    if (min == null) {
                        min = node;
                        index = i;
                    } else if (min.val > node.val) {
                        min = node;
                        index = i;
                    }
                }
            }
            if (min != null) {
                cur.next = min;
                cur = cur.next;
                min = min.next;
                lists[index] = min;
            } else {
                break;
            }
        }
        return dummy.next;
    }
}
