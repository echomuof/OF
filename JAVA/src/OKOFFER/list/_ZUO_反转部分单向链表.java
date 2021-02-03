package OKOFFER.list;

import utils.ListNode;

import java.util.List;

/**
 * @author: wangdarui
 * @created: 2021/2/3
 */
public class _ZUO_反转部分单向链表 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode newHead = reversePart(listNode, 2, 4);
        while (newHead != null) {
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }

    public static ListNode reversePart(ListNode head, int from, int to) {
        int len = 0;
        ListNode tmp = head;
        ListNode fPre = null;
        ListNode tPos = null;
        while (tmp != null) {
            len++;
            fPre = len == from - 1 ? tmp : fPre;
            tPos = len == to + 1 ? tmp : tPos;
            tmp = tmp.next;
        }
        if (from > to || from < 1 || to > len) return head;
        ListNode pre = fPre == null ? head : fPre.next;
        ListNode cur = pre.next;
        pre.next = tPos;
        while (cur != tPos) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (fPre != null) {
            fPre.next = pre;
            return head;
        }
        return pre;
    }

}
