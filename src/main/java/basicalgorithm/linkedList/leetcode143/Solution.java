package basicalgorithm.linkedList.leetcode143;

/**
 * 143. 重排链表
 * https://leetcode.cn/problems/reorder-list/
 */
public class Solution {

    /**
     * 快慢指针
     * 1. 找到前半部分链表的尾节点
     * 2. 反转后半部分链表
     * 3. 两链表交叉搞一个新链表
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 快慢指针 找到前半部分链表的尾节点
        ListNode fast = head;
        ListNode slow = head;
        // 这种方式会使得前半部分链表稍长(链表长度为奇数时)
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 这个时候slow是前半部分链表的尾节点 slow.next是后半部分链表的头节点
        // 翻转后半部分链表
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 切断前半部分链表
        slow.next = null;
        // 合并两链表
        ListNode h1 = head;
        ListNode h2 = pre;

        ListNode h1Cur = h1;
        ListNode h2Cur = h2;

        while (h1Cur != null && h2Cur != null) {
            ListNode h1CurNextTemp = h1Cur.next;
            ListNode h2CurNextTemp = h2Cur.next;
            h1Cur.next = h2Cur;
            h2Cur.next = h1CurNextTemp;
            h1Cur = h1CurNextTemp;
            h2Cur = h2CurNextTemp;
        }
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
