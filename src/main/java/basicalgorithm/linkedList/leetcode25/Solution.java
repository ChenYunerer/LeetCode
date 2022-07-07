package basicalgorithm.linkedList.leetcode25;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.ListNode testListNode = solution.genListNode(new int[]{1, 2, 3, 4, 5});
        Solution.ListNode resultListNode = solution.reverseKGroup(testListNode, 2);
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode pre = vHead;
        ListNode cur = vHead.next;
        while (cur != null) {
            ListNode cur1 = cur;
            int i = 1;
            while (i < k && cur1 != null) {
                cur1 = cur1.next;
                i++;
            }
            // 当前cur处于待翻转子串头部 cur1处于待翻转子串的尾部 如果cur1为null 则表示剩余子串不够k数 不需要翻转了
            // 开始翻转子串
            if (cur1 != null) {
                ListNode cur1Next = cur1.next;
                ListNode pre2 = pre;
                ListNode cur2 = cur;
                while (cur2 != null && cur2 != cur1Next) {
                    ListNode temp = cur2.next;
                    cur2.next = pre2;
                    pre2 = cur2;
                    cur2 = temp;
                }
                // 头尾处理
                pre.next = cur1;
                cur.next = cur2;
            } else {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return vHead.next;
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
