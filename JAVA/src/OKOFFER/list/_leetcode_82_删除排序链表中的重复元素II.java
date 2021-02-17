package OKOFFER.list;

import utils.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _leetcode_82_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead.next;
        ListNode pre = newHead;
        while (cur != null) {
            int diffCount = 0;
            ListNode diffNode = cur;
            while (diffNode != null && diffNode.val == cur.val) {
                diffCount++;
                diffNode = diffNode.next;
            }
            if (diffCount > 1) {
                pre.next = diffNode;
            } else {
                pre = cur;
            }
            cur = diffNode;
        }
        return newHead.next;
    }
}
