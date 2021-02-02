package OKOFFER.leetcode;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/1
 */
public class _2_两数相加 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.buildListNode(new int[]{9, 9, 9, 9});
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        int carry = 0;
        ListNode cur = newHead;
        while (l1 != null || l2 != null) {
            int v = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = v / 10;
            cur.next = new ListNode(v % 10);
            cur = cur.next;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(1);
        }
        return newHead.next;
    }
}
