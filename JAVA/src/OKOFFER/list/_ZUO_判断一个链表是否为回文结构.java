package OKOFFER.list;

import utils.ListNode;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/3
 */
public class _ZUO_判断一个链表是否为回文结构 {
    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head.next;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) return false;
            head = head.next;
        }
        return true;
    }


}
