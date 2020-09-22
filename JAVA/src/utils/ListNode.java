package utils;

/**
 * @author: wangdarui
 * @date: 2020/9/15
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                pre.next = new ListNode(arr[i]);
                pre = pre.next;
            }
        }
        return head;
    }
}
