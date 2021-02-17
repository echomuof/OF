package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _leetcode_61_旋转链表 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode listNode1 = rotateRight(listNode, 2);
        while (listNode1 != null) {
            System.out.print(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        ListNode cur = head;
        int len = 1;
        ListNode tail = null;
        while (cur.next != null) {
            len++;
            cur = cur.next;
            tail = cur;
        }
        cur = head;
        k %= len;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        cur = head;
        while (k < -1) {
            k++;
            cur = cur.next;
        }
        tail.next = head;
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
}
