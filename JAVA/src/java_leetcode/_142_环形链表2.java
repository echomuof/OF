package java_leetcode;

import javafx.application.Application;
import javafx.stage.Stage;

public class _142_环形链表2 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (true) {
            if (f == null || f.next == null) {
                return null;
            }
            s = s.next;
            f = f.next.next;
            if (s == f) {
                break;
            }
        }
        s = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        return s;
    }
}
