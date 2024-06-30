package leetcode_top_100.linked_list.lc23;

import categorized.linkedList.base.ListNode;

/**
 * 23. 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (true) {
            ListNode min = null;
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    if (min == null) {
                        min = node;
                        index = i;
                    } else if (min.val > node.val) {
                        min = node;
                        index = i;
                    }
                }
            }
            if (min != null) {
                cur.next = min;
                cur = cur.next;
                min = min.next;
                lists[index] = min;
            } else {
                break;
            }
        }
        return dummy.next;
    }


    /**
     * 顺序合并
     */
    public ListNode mergeKLists0(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists0(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists0(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }


    /**
     * 分治合并
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        return mergeKLists1(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists1(ListNode[] lists, int indexStart, int indexEnd) {
        if (indexStart == indexEnd) {
            return lists[indexStart];
        }
        if (indexStart > indexEnd) {
            return null;
        }
        int mid = (indexStart + indexEnd) / 2;
        ListNode a = mergeKLists1(lists, indexStart, mid);
        ListNode b = mergeKLists1(lists, mid + 1, indexEnd);
        return merge2List(a, b);
    }

    private ListNode merge2List(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
                cur = cur.next;
            } else {
                cur.next = b;
                b = b.next;
                cur = cur.next;
            }
        }
        cur.next = a != null ? a : b;
        return dummy.next;
    }




}
