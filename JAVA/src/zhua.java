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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class zhua {

    public static void main(String[] args) throws IOException {
        Integer aa = new Integer(123123);
        System.out.println(aa.equals(Score.EA.getSs()));
        zhua z = new zhua();
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

enum Score {

    EA(123123, "asdasd"),
    ;

    private Integer ss;
    private String aa;

    public Integer getSs() {
        return ss;
    }

    public void setSs(Integer ss) {
        this.ss = ss;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    Score(Integer ss, String aa) {
        this.ss = ss;
        this.aa = aa;
    }
}



























