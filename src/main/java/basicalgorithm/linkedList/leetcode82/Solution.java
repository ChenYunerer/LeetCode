package basicalgorithm.linkedList.leetcode82;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.genListNode(new int[]{0, 0, 1, 1, 2, 2, 3});
        solution.printLinkNode(listNode);
        ListNode result = solution.deleteDuplicates(listNode);
        solution.printLinkNode(result);
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // todo
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
