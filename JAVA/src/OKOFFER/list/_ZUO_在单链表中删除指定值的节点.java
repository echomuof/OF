package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_在单链表中删除指定值的节点 {

    public ListNode removeValue(ListNode head, int value) {
        while (head != null) {
            if (head.val != value) break;
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}


