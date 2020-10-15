package 剑指offer;

import utils.ListNode;

import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _52_两个链表的第一个公共节点 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
}
