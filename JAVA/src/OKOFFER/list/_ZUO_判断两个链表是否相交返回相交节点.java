package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_判断两个链表是否相交返回相交节点 {

    public ListNode getIntersectNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        //两个无环链表相交
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        //两个有环链表相交
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    private ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        //环外相交
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int len = 0;
            while (cur1.next != null) {
                cur1 = cur1.next;
                len++;
            }
            while (cur2.next != null) {
                cur2 = cur2.next;
                len--;
            }
            if (cur1 != cur2) return null;
            cur1 = len > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            len = Math.abs(len);
            while (len != 0) {
                len--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            //环内相交
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) return loop1;
                cur1 = cur1.next;
            }
            return null;
        }

    }

    private ListNode noLoop(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int len = 0;
        while (cur1.next != null) {
            cur1 = cur1.next;
            len++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            len--;
        }
        if (cur1 != cur2) return null;
        cur1 = len > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        len = Math.abs(len);
        while (len != 0) {
            len--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 获取环的入口节点
     *
     * @param head
     * @return
     */
    private ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
