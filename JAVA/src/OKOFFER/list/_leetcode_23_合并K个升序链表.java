package OKOFFER.list;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _leetcode_23_合并K个升序链表 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{1, 4, 5});
        ListNode l2 = ListNode.buildListNode(new int[]{1, 3, 4});
        ListNode l3 = ListNode.buildListNode(new int[]{2, 6});
        ListNode listNode = mergeKLists(new ListNode[]{l1, l2, l3});
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        int k = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (min >= lists[i].val) {
                min = lists[i].val;
                k = i;
            }
        }
        if (lists[k] != null) {
            newHead = new ListNode(lists[k].val);
            lists[k] = lists[k].next;
        }
        if (min == Integer.MAX_VALUE) return null;
        newHead.next = mergeKLists(lists);
        return newHead;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next!=null) queue.add(p.next);
        }
        return newHead.next;
    }

}
