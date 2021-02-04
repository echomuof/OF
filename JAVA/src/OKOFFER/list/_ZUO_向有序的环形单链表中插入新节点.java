package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_向有序的环形单链表中插入新节点 {
    public ListNode insertNum(ListNode head, int num) {
        ListNode node = new ListNode(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != pre) {
            if (num >= pre.val && num <= cur.val) break;
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.val < num ? head : node;
    }
}
