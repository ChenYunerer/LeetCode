package categorized.linkedList.leetcode234;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
public class Solution {

    /**
     * 转变成数组之后再做
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        List<Integer> valList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            valList.add(cur.val);
            cur = cur.next;
        }
        int start = 0;
        int end = valList.size() - 1;
        while (start < end) {
            if (!valList.get(start).equals(valList.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 快慢指针
     * 1. 找到前半部分链表的尾节点
     * 2. 反转后半部分链表
     * 3. 判断是否回文
     * 4. 恢复链表
     * 5. 返回结果
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        // 快慢指针 寻找前半个链表末尾
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 则为前半个链表末尾 slow.next 则为后半个链表的头
        // 翻转后半个链表
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // pre现在为翻转后链表的头
        // 开始比较回文
        ListNode h1 = head;
        ListNode h2 = pre;
        boolean isPalindrome = true;
        while (isPalindrome && h2 != null) {
            if (h1.val != h2.val) {
                isPalindrome = false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        // 恢复链表 把后半个翻回来
        cur = pre;
        pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        slow.next = pre;
        return isPalindrome;
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
