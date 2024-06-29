package categorized.linkedList.leetcode1721;

/**
 * 1721. 交换链表中的节点
 * https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/
 */
public class Solution {

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode first = vHead;
        ListNode firstPre = null;
        ListNode slow = vHead;
        ListNode slowPre = null;
        int step = 0;
        ListNode firstNode = null;
        ListNode firstNodePre = null;
        while (first.next != null) {
            firstPre = first;
            first = first.next;
            step++;
            if (step >= k) {
                slowPre = slow;
                slow = slow.next;
            }
            if (step == k) {
                firstNodePre = firstPre;
                firstNode = first;
            }
        }
        if (firstNode == slowPre) {
            ListNode slowNextTemp = slow.next;
            firstNodePre.next = slow;
            slow.next = firstNode;

            firstNode.next = slowNextTemp;
        } else if (slow == firstNodePre) {
            ListNode firstNodeNextTemp = firstNode.next;
            slowPre.next = firstNode;
            firstNode.next = slow;
            slow.next = firstNodeNextTemp;
        } else {

            ListNode slowNextTemp = slow.next;
            firstNodePre.next = slow;
            slow.next = firstNode.next;

            slowPre.next = firstNode;
            firstNode.next = slowNextTemp;
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
