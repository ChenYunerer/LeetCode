package basicalgorithm.linkedList.leetcode82;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = solution.genListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode listNode2 = solution.genListNode(new int[]{1, 1, 1, 2, 3, 4, 5});
        ListNode listNode3 = solution.genListNode(new int[]{1, 1, 1, 3, 3});
        ListNode listNode4 = solution.genListNode(new int[]{1, 2, 2});
        solution.printLinkNode(listNode4);
        ListNode result = solution.deleteDuplicates(listNode4);
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
        if (head == null || head.next == null) {
            return head;
        }
        // 因为最终链表头可能变化 所以搞一个虚拟头
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode pre = vHead;
        ListNode cur = vHead.next;
        while (cur != null) {
            // 假定当前就是重复的第一个
            int duplicateValue = cur.val;
            // 有点类似于滑动窗口，找到最后一个重复的，cur移动到最后一个重复的位置
            while (cur.next != null && cur.next.val == duplicateValue) {
                cur = cur.next;
            }
            // 判断pre和cur是否还是连续
            if (pre.next == cur) {
                // 如果pre和cur还是连续，说明上面并没有重复
                // 只要把pre和cur往前移动一步然后继续大循环就可以了
                pre = cur;
                cur = cur.next;
            } else {
                // 如果pre和cur不连续了，说明中间出现了连续值
                // cur当前处在最后一个连续值的位置，并且这个节点也是需要删除的
                // 所以cur前进一步，并且pre.next指向cur(等于删除中间所有重复项)
                cur = cur.next;
                pre.next = cur;
            }

        }
        return vHead.next;
    }

    public ListNode removeSameHead(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int duplicateValue = head.val;
        while (cur.next != null && cur.next.val == duplicateValue) {
            cur = cur.next;
        }
        return cur.next;
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
