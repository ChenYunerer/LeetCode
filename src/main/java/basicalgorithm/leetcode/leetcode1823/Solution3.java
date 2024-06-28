package basicalgorithm.leetcode.leetcode1823;

/**
 * 1823. 找出游戏的获胜者
 * https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
 */
public class Solution3 {


    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int result = solution.findTheWinner(5, 1);
        System.out.println(result);
    }

    /**
     * 通过单向链表构建一个环来模拟场景，通过递归删除对应位置的节点，直到只剩一个节点结束
     * 对k==1做特殊处理就可以不用双向链表了，简单一点
     */
    public int findTheWinner(int n, int k) {
        // 对k==1做特殊处理就可以不用双向链表了，简单一点
        if (k == 1) {
            return n;
        }
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
        while (i < k - 1) {
            cur = cur.next;
            i++;
        }
        cur.next = cur.next.next;
        return doFindTheWinner(cur.next, k);
    }

    public ListNode genListNode(int n) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int i = 2;
        while (i <= n) {
            ListNode next = new ListNode(i);
            cur.next = next;

            cur = next;
            i++;
        }
        cur.next = head;
        return head;
    }


    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
