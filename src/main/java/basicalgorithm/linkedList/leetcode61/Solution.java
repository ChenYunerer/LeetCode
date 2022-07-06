package basicalgorithm.linkedList.leetcode61;

/**
 * 61. 旋转链表
 * https://leetcode.cn/problems/rotate-list/
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 首先找到链表尾巴 把尾巴和头连到一起 形成一个环
        ListNode cur = head;
        int length = 1;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        // 此时cur为链表尾部节点
        // 构建一个环
        cur.next = head;
        k = k % length;
        // 根据k在合适位置切断环
        cur = head;
        int j = length - k;
        for (int i = 1; i < j; i++) {
            cur = cur.next;
        }
        // 切断环
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
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
