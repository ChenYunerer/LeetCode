package basicalgorithm.linkedList.leetcode1823;

/**
 * 1823. 找出游戏的获胜者
 * https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findTheWinner(5, 1);
        System.out.println(result);
    }

    /**
     * 通过双向链表构建一个环来模拟场景，通过递归删除对应位置的节点，直到只剩一个节点结束
     */
    public int findTheWinner(int n, int k) {
        ListNode listNode = genListNode(n);
        ListNode result = doFindTheWinner(listNode, k);
        return result.val;
    }

    public ListNode doFindTheWinner(ListNode head, int k) {
        if (head == null || head.next == head) {
            return head;
        }
        ListNode cur = head;
        int i = 1;
        while (i < k) {
            cur = cur.next;
            i++;
        }
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        return doFindTheWinner(cur.next, k);
    }

    public ListNode genListNode(int n) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int i = 2;
        while (i <= n) {
            ListNode next = new ListNode(i);
            next.pre = cur;
            cur.next = next;

            cur = next;
            i++;
        }
        cur.next = head;
        head.pre = cur;
        return head;
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
