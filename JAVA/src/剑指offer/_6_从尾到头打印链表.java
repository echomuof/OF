package 剑指offer;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _6_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] res = new int[len];
        int i = len - 1;
        while (head != null) {
            res[i] = head.val;
            head = head.next;
            i--;
        }
        return res;
    }

}
