package basicalgorithm.linkedList.leetcode23;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @author yunyu.cy
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        return null;
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
