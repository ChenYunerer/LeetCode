package categorized.linkedList.swordtooffer023;

/**
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 * https://leetcode.cn/problems/3u1WK4/
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aCur = headA;
        while (aCur != null) {
            ListNode bCur = headB;
            while (bCur != null) {
                if (aCur == bCur) {
                    return aCur;
                }
                bCur = bCur.next;
            }
            aCur = aCur.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
