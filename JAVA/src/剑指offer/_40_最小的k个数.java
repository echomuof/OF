package 剑指offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: wangdarui
 * @created: 2020/10/13
 */
public class _40_最小的k个数 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        _40_最小的k个数 a = new _40_最小的k个数();
        int[] leastNumbers = a.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(leastNumbers));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i : arr) {
            heap.offer(i);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
