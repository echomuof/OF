package OKOFFER.list;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_删除无序单链表中值重复出现的节点 {
    public void removeRep(ListNode head) {
        if (head == null || head.next == null) return;
        Set<Integer> set = new HashSet<>();
        ListNode pre = head;
        ListNode cur = pre.next;
        set.add(pre.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}
