package categorized.linkedList.leetcode1472;

/**
 * 1472. 设计浏览器历史记录
 * https://leetcode.cn/problems/design-browser-history/
 */
public class BrowserHistory {

    ListNode homePageNode;
    ListNode cur;

    public BrowserHistory(String homepage) {
        ListNode homePageNode = new ListNode(homepage, null, null);
        this.homePageNode = homePageNode;
        cur = homePageNode;
    }

    public void visit(String url) {
        ListNode next = new ListNode(url, cur, null);
        cur.next = next;
        cur = next;
    }

    public String back(int steps) {
        int count = 0;
        while (count < steps && cur != homePageNode) {
            cur = cur.pre;
            count++;
        }
        return cur.url;
    }

    public String forward(int steps) {
        int count = 0;
        while (count < steps && cur.next != null) {
            cur = cur.next;
            count++;
        }
        return cur.url;
    }

    class ListNode {
        String url;
        ListNode pre;
        ListNode next;

        public ListNode(String url) {
            this.url = url;
        }

        public ListNode(String url, ListNode pre, ListNode next) {
            this.url = url;
            this.pre = pre;
            this.next = next;
        }
    }
}
