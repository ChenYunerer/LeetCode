package basicalgorithm.linkedList.leetcode24;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * @author yunyu.cy
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode testListNode = solution.genListNode(new int[]{1, 2, 3, 4});
        solution.printLinkNode(testListNode);
        ListNode resultListNode = solution.swapPairs2(testListNode);
        solution.printLinkNode(resultListNode);
    }

    public ListNode genListNode(int[] array) {
        ListNode vHead = new ListNode();
        ListNode cur = vHead;
        for (int value : array) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        return vHead.next;
    }

    public void printLinkNode(ListNode head) {
        String str = String.valueOf(head.val);
        while (head.next != null) {
            str = str + "-->" + head.next.val;
            head = head.next;
        }
        System.out.println(str);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode pre = vHead;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            cur.next = temp;

            pre = cur;
            cur = cur.next;
        }
        return vHead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //一共三个节点:head, next, swapPairs(next.next)
        //下面的任务便是交换这3个节点中的前两个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
        return next;
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
