package basicalgorithm.linkedList.leetcode2130;

/**
 * 2130. 链表最大孪生和
 * https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode test = solution.genListNode(new int[]{5, 4, 2, 1});
        int result = solution.pairSum(test);
        System.out.println(result);
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

    /**
     * 快慢指针 加 链表翻转
     */
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        ListNode cur1 = head;
        ListNode cur2 = pre;
        int max = 0;
        while (cur1 != null && cur2 != null) {
            int value = cur1.val + cur2.val;
            if (value > max) {
                max = value;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return max;
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
