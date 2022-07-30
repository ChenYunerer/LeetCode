package basicalgorithm.recursion.leetcode390;

/**
 * 390. 消除游戏
 * https://leetcode.cn/problems/elimination-game/
 * todo
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int output = solution.lastRemaining(1000000000);
        System.out.println(output);
    }

    /**
     * 通过双向链表进行模拟
     * 可行，但是内存超过限制
     */
    public int lastRemaining(int n) {
        ListNode head = genListNodeWithVHeadAndVTail(n);
        ListNode resultListNode = deleteListNode(head, true);
        return resultListNode.next != null ? resultListNode.next.val : resultListNode.pre.val;
    }

    public ListNode deleteListNode(ListNode vHeadOrTail, boolean forward) {
        if (forward && (vHeadOrTail.next.next.next == null)) {
            return vHeadOrTail;
        }
        if ((!forward) && (vHeadOrTail.pre.pre.pre == null)) {
            return vHeadOrTail;
        }
        ListNode cur = vHeadOrTail;
        boolean shouldDelete = false;
        while ((forward ? cur.next : cur.pre) != null) {
            if (shouldDelete) {
                if (cur.pre != null) {
                    cur.pre.next = cur.next;
                }
                if (cur.next != null) {
                    cur.next.pre = cur.pre;
                }
            }
            shouldDelete = !shouldDelete;
            cur = forward ? cur.next : cur.pre;
        }
        return deleteListNode(cur, !forward);
    }

    public ListNode genListNodeWithVHeadAndVTail(int n) {
        ListNode vHead = new ListNode();
        ListNode cur = vHead;
        int i = 1;
        while (i <= n) {
            ListNode next = new ListNode(i);
            next.pre = cur;
            cur.next = next;

            cur = next;
            i++;
        }
        ListNode vTail = new ListNode();
        vTail.pre = cur;
        cur.next = vTail;
        return vHead;
    }


    class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode pre, ListNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
