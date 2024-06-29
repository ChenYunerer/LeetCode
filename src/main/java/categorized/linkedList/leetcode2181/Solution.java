package categorized.linkedList.leetcode2181;

/**
 * 2181. 合并零之间的节点
 * https://leetcode.cn/problems/merge-nodes-in-between-zeros/
 */
public class Solution {

    public ListNode mergeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode pre = vHead;
        ListNode cur = vHead.next;
        while (cur != null) {
            if (cur.next != null && cur.next.val == 0) {
                // 保留当前cur节点
                pre = cur;
                cur = cur.next;
            } else {
                // 删除当前cur节点
                if (cur.val == 0) {
                    // 如果当前节点是0
                    pre.next = cur.next;
                    cur = cur.next;
                } else {
                    // 如果当前节点非0
                    pre.next = cur.next;
                    cur.next.val = cur.val + cur.next.val;
                    cur = cur.next;
                }
            }
        }
        return vHead.next;
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
