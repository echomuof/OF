package 剑指offer;

import utils.ListNode;

import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/28
 */
public class _25_合并两个排序的链表 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{-9, 3});
        ListNode l2 = ListNode.buildListNode(new int[]{5, 7});
        ListNode newHead = mergeTwoLists(l1, l2);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pre = new ListNode();
        ListNode newHead = pre;
        while (l1 != null && l2 != null) {
            pre.next = l1.val >= l2.val ? new ListNode(l2.val) : new ListNode(l1.val);
            if (l1.val >= l2.val) l2 = l2.next;
            else l1 = l1.next;
            pre = pre.next;
        }
        while (l1 != null) {
            pre.next = new ListNode(l1.val);
            l1 = l1.next;
            pre = pre.next;
        }
        while (l2 != null) {
            pre.next = new ListNode(l2.val);
            l2 = l2.next;
            pre = pre.next;
        }
        return newHead.next;
    }
}
