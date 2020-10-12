package 剑指offer;

import utils.ListNode;

import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/10/10
 */
public class _22_链表中倒数第k个节点 {
    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            if (p1==null) return null;
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
