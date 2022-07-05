package basicalgorithm.linkedList.leetcode82;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = solution.genListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode listNode2 = solution.genListNode(new int[]{1, 1, 1, 2, 3, 4, 5});
        ListNode listNode3 = solution.genListNode(new int[]{1, 1, 1});
        ListNode listNode4 = solution.genListNode(new int[]{1, 2, 2});
        solution.printLinkNode(listNode3);
        ListNode result = solution.deleteDuplicates(listNode3);
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
        if (head == null) {
            System.out.println("null");
            return;
        }
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
        if (head.next == null) {
            return head;
        }
        ListNode resultHead = null;
        ListNode pre = null;
        ListNode cur = head;
        Integer duplicateValue = null;
        while (cur.next != null) {
            if (duplicateValue != null && cur.val == duplicateValue) {
                cur = cur.next;
                if (pre != null) {
                    pre.next = cur;
                } else {
                    resultHead = cur;
                }
            } else {
                if (cur.val == cur.next.val) {
                    duplicateValue = cur.val;
                    cur = cur.next;
                    if (pre != null) {
                        pre.next = cur;
                    }
                } else {
                    if (resultHead == null) {
                        resultHead = cur;
                    }
                    duplicateValue = null;
                    pre = cur;
                    cur = cur.next;
                }
            }
        }
        if (duplicateValue != null && cur.val == duplicateValue && pre != null) {
            pre.next = null;
        }
        return resultHead;
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
