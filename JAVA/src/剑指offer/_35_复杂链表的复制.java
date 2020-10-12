package 剑指offer;

import utils.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2020/10/12
 */
public class _35_复杂链表的复制 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
