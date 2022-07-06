package basicalgorithm.linkedList.leetcode19;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 原本的头节点也可能被删除 所以搞个虚拟头节点
        ListNode vHead = new ListNode();
        vHead.next = head;

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 快指针先走n - 1 步
        int i = 1;
        while (i < n) {
            fast = fast.next;
            i++;
        }
        // 快慢指针一起走 直到快指针到尾部
        // 由于涉及到删除 所以还需要一个前指针pre
        ListNode pre = vHead;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        // 此时slow则为倒数第n个节点
        // 删除slow节点
        pre.next = slow.next;
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
