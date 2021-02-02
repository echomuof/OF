package OKOFFER.stack_queue;

import javax.sound.sampled.LineUnavailableException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_最大值减去最小值小于或等于num的子数组数量 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(getNum(nums, 2));
    }

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) return 0;
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int ans = 0;
        int L = 0;
        int R = 0;
        while (L < arr.length) {
            while (R < arr.length) {
                if (qmin.isEmpty() || qmin.peekLast() != R) {
                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(R);
                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                        qmax.pollLast();
                    }
                    qmax.addLast(R);
                }
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) break;
                R++;
            }
            ans += R - L;
            if (qmin.peekFirst() == L) qmin.pollFirst();
            if (qmax.peekFirst() == L) qmax.pollFirst();
            L++;
        }
        return ans;
    }
}
