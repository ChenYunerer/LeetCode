package categorized.linkedList.leetcode2095;

/**
 * 2095. 删除链表的中间节点
 * https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode test = solution.genListNode(new int[]{1, 2, 3, 4});
        ListNode result = solution.deleteMiddle2(test);
        solution.printLinkNode(result);
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode first = vHead;
        ListNode slow = vHead;

        while (first != null && first.next != null && first.next.next != null) {
            first = first.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return vHead.next;
    }

    public ListNode deleteMiddle2(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        temp.next = temp.next.next;
        return head;
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
