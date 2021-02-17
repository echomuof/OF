package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _leetcode_86_分隔链表 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{1, 4, 3, 2, 5, 2});
        partition(listNode, 3);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode big = new ListNode(0);
        ListNode bigHead = big;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }
}
