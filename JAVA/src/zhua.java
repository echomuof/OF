import utils.ListNode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class zhua {

    public static void main(String[] args) throws IOException {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        ListNode newHead = resort(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static ListNode resort(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode ji = head;
        ListNode ouHead = head.next;
        while (ji.next != null) {
            ListNode nextJi = ji.next.next;
            ListNode nextOu = ji.next;
            ji.next = nextJi;
            nextOu.next = nextJi.next;
            ji = ji.next;
        }
        ji.next = ouHead;
        return head;
    }

}



























