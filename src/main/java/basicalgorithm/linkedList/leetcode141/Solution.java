package basicalgorithm.linkedList.leetcode141;

import java.util.ArrayList;
import java.util.List;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    /**
     * 通过List记录走过的Node，如果之后走的在List中则表示有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            if (nodeList.contains(cur)) {
                return true;
            } else {
                nodeList.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 快慢指针
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
