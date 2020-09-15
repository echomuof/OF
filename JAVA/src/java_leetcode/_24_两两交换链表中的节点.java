package java_leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/15
 */
public class _24_两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode node = swapPairs(n1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode tmp = pre;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }
        return pre.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
