package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/3
 */
public class _leetcode_25_k个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        ListNode end = newHead;
        while (end.next != null) {
            //找到当前组中的第k个节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //end=null说明当前组长度不足k，直接返回
            if (end == null) break;
            //暂存当前组的头结点
            ListNode start = pre.next;
            //暂存下一组的头节点
            ListNode endPos = end.next;
            //将当前组的尾结点的next设置为null
            end.next = null;
            //进行翻转，新的头结点为原来的尾结点，设置为pre的next
            pre.next = reverseList(start);
            //旧的头结点的next为下一组的头结点
            start.next = endPos;
            //更新pre、end，开启下一组翻转
            pre = start;
            end = start;
        }
        return newHead.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
