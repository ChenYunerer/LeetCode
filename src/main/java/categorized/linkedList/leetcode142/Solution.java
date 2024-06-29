package categorized.linkedList.leetcode142;

import java.util.ArrayList;
import java.util.List;

/**
 * 142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            if (nodeList.contains(cur)) {
                return cur;
            } else {
                nodeList.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * 详情见leetcode题解
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode entry = head;
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
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
