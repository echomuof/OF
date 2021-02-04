package OKOFFER.list;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_复制含有随机指针的链表 {

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        copyListWithRand2(head);
    }

    public ListNode copyListWithRand1(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static ListNode copyListWithRand2(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = new ListNode(cur.val * 10);
            cur.next.next = next;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            ListNode copy = cur.next;
            cur = cur.next.next;
        }
        ListNode ans = head.next;
        cur = head;
        while (cur.next.next != null) {
            ListNode next = cur.next.next;
            ListNode copy = cur.next;
            cur.next = cur.next.next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return ans;
    }
}
