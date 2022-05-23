package basicalgorithm;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 反转链表
 */
public class ReverseLinkNode {

    public static LinkNode reverseLinkNodeReturnHead(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode pre = null;
        LinkNode current = head;
        while (current != null) {
            LinkNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    public static LinkNodeHeadAndTail reverseLinkNodeReturnHeadAndTail(LinkNode head) {
        if (head == null || head.next == null) {
            return new LinkNodeHeadAndTail(head, null);
        }
        LinkNode pre = null;
        LinkNode current = head;
        while (current != null) {
            LinkNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return new LinkNodeHeadAndTail(pre, head);
    }

    public static void main(String[] args) {
        LinkNode head = genLinkNode(10);
        printLinkNode(head);

        //LinkNode reversedLinkNode = reverseLinkNodeReturnHead(head);
        //printLinkNode(reversedLinkNode);

        LinkNodeHeadAndTail linkNodeHeadAndTail = reverseLinkNodeReturnHeadAndTail(head);
        printLinkNode(linkNodeHeadAndTail.getHead());
        printLinkNode(linkNodeHeadAndTail.getTail());
    }

    public static LinkNode genLinkNode(int length) {
        LinkNode head = new LinkNode(0);
        LinkNode cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new LinkNode(i);
            cur = cur.next;
        }
        return head;
    }

    public static void printLinkNode(LinkNode head) {
        String str = String.valueOf(head.value);
        while (head.next != null) {
            str = str + "-->" + head.next.value;
            head = head.next;
        }
        System.out.println(str);
    }


    @Data
    @AllArgsConstructor
    private static class LinkNodeHeadAndTail {
        private LinkNode head;
        private LinkNode tail;
    }

    static class LinkNode {
        int value;
        LinkNode next;

        public LinkNode(int value) {
            this.value = value;
        }

        public LinkNode(int value, LinkNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
