package categorized.linkedList.leetcode1171;

import java.util.HashMap;
import java.util.Map;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
public class Solution {

    /**
     * 暴力求解
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }

        // 涉及到删除 头节点也可能被删除 所以搞个虚拟头
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode pre = vHead;
        ListNode cur = head;

        while (cur != null) {
            // 滑动窗口开始滑动 end表示剩余子串的头节点(滑动窗口尾部的.next)
            ListNode end = cur.next;
            int total = cur.val;

            while (total != 0 && end != null) {
                total = total + end.val;
                end = end.next;
            }
            // 如果total等于0则说明出现了需要删除的子串 当前end为剩余子串的头（可能为null）
            if (total == 0) {
                // 删除子串
                pre.next = end;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        return vHead.next;
    }

    /**
     * 前缀和
     */
    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
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
