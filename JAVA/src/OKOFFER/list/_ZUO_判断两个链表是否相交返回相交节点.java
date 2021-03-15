package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_判断两个链表是否相交返回相交节点 {

    public ListNode getIntersectNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;

        //获取环形入口节点
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);

        //入口节点都为null，证明两个无环链表相交
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }

        //入口节点都不为null，证明两个有环链表相交
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }

        //一个有环，一个无环，肯定不相交

        return null;
    }

    private ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;

        //环外相交，和两个无环链表相交方法一样，只是将链表尾部设置为【入环节点】
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int len = 0;
            while (cur1.next != loop1) {
                cur1 = cur1.next;
                len++;
            }
            while (cur2.next != loop2) {
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
            //其中一个链表的入环节点就是相交节点
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

        //存储cur1的长度
        int len = 0;

        //计算cur1的长度
        while (cur1.next != null) {
            cur1 = cur1.next;
            len++;
        }

        //计算cur1与cur2长度的差值
        while (cur2.next != null) {
            cur2 = cur2.next;
            len--;
        }

        //此时cur1、cur2为两个链表的尾部，如果两个链表的尾部不相同，说明不相交
        if (cur1 != cur2) return null;

        //长的链表先走【差值】步，然后两个链表一起走，相遇的节点就是相交节点
        //差值为两个链表长度的差值
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
