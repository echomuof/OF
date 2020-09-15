package java_leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/15
 */
public class _21_合并两个有序链表 {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node6 = new ListNode(4);
        ListNode node5 = new ListNode(3, node6);
        ListNode node4 = new ListNode(1, node5);

        ListNode node = mergeTwoLists(node1, node4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

