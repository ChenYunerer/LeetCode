package basicalgorithm.linkedList.leetcode92;

/**
 * 反转子链表
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class ReverseLinkNode {

    public static ListNode reverseBetween_byMyself(ListNode head, int left, int right) {
        // 避免空指针
        if (head == null || head.next == null) {
            return head;
        }
        // 两者相同不需要进行反转
        if (left == right) {
            return head;
        }
        // 用于子链表反转
        ListNode pre = null;
        ListNode cur = head;
        // 用于记录子链表头的前一个Node
        ListNode fixedHead = null;
        // 用于记录子链表头
        ListNode subListNodeHead = null;
        // 用于记录子链表尾的后一个Node
        ListNode fixedTail = null;
        // index表示cur所在的位置从1开始
        int index = 1;
        // 定位到需要反转的链表头，并记录这个头前面的这个Node
        while (index < left) {
            pre = cur;
            cur = cur.next;
            // 还没移动到子链表头就没有Node了，则直接结束
            if (cur == null) {
                return head;
            }
            fixedHead = pre;
            index++;
        }
        subListNodeHead = cur;
        // 移动到子链表尾部或全链表尾部则结束
        while (cur != null && index <= right) {
            ListNode temp = cur.next;
            cur.next = pre;
            // pre后移一步
            pre = cur;
            // cur后移一步
            cur = temp;
            index++;
        }
        // 子链表后一个node，可能为null
        fixedTail = cur;
        // 执行到这里cur fixedTail表示子链表的后一个阶段 pre表示子链表尾节点
        // cur fixedTail有可能为空
        // pre不可能为空
        if (fixedHead != null) {
            fixedHead.next.next = fixedTail;
            fixedHead.next = pre;
            return head;
        } else {
            subListNodeHead.next = fixedTail;
            return pre;
        }
    }

    /**
     * 增加了一个虚拟头节点，避免对子链表头前一个节点的讨论
     */
    public static ListNode reverseBetween_virtualHeadNode(ListNode head, int left, int right) {
        // 避免空指针
        if (head == null || head.next == null) {
            return head;
        }
        // 两者相同不需要进行反转
        if (left == right) {
            return head;
        }
        ListNode virtualHeadNode = new ListNode(-1);
        virtualHeadNode.next = head;

        // 用于子链表反转
        ListNode pre = virtualHeadNode;
        ListNode cur = head;
        // 用于记录子链表头的前一个Node
        ListNode fixedHead = virtualHeadNode;
        // 用于记录子链表尾的后一个Node
        ListNode fixedTail = null;
        // index表示cur所在的位置从1开始
        int index = 1;
        // 定位到需要反转的链表头，并记录这个头前面的这个Node
        while (index < left) {
            pre = cur;
            cur = cur.next;
            // 还没移动到子链表头就没有Node了，则直接结束
            if (cur == null) {
                return head;
            }
            fixedHead = pre;
            index++;
        }
        // 移动到子链表尾部或全链表尾部则结束
        while (cur != null && index <= right) {
            ListNode temp = cur.next;
            cur.next = pre;
            // pre后移一步
            pre = cur;
            // cur后移一步
            cur = temp;
            index++;
        }
        // 子链表后一个node，可能为null
        fixedTail = cur;
        // 执行到这里cur fixedTail表示子链表的后一个阶段 pre表示子链表尾节点
        // cur fixedTail有可能为空
        // pre不可能为空

        fixedHead.next.next = fixedTail;
        fixedHead.next = pre;

        return virtualHeadNode.next;
    }

    public static void main(String[] args) {
        ListNode head = genLinkNode(5);
        printLinkNode(head);

        ListNode reversedListNode = reverseBetween_virtualHeadNode(head, 2, 4);
        printLinkNode(reversedListNode);
    }

    public static ListNode genLinkNode(int length) {
        int start = 1;
        ListNode head = new ListNode(start);
        ListNode cur = head;
        for (int i = start + 1; i <= length; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head;
    }

    public static void printLinkNode(ListNode head) {
        String str = String.valueOf(head.value);
        while (head.next != null) {
            str = str + "-->" + head.next.value;
            head = head.next;
        }
        System.out.println(str);
    }


    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
