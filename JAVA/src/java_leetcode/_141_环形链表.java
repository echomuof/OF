package java_leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/15
 */
public class _141_环形链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p2.next != null) {
            if (p1.val == p2.val) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }
}
