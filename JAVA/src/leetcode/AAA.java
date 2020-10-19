package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: wangdarui
 * @created: 2020/9/29
 */
public class AAA {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = scanner.next();
        String[] split = str.split("");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }*/
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums, 5));
    }

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static int jump(int[] nums, int N) {
        if (nums == null || nums.length == 0 || N > nums.length) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        return recur(nums, 0, 0, N);
    }

    Map<Integer, Integer> note = new HashMap<>();

    public static int recur(int[] nums, int index, int count, int N) {
        if (index == N - 1) {
            return count;
        }
        int ans1 = recur(nums, index + 1, count + 1, N);
        int ans2 = Integer.MAX_VALUE;
        List<Integer> curList = map.get(nums[index]);
        for (int i = 0; i < curList.size(); i++) {
            Integer cur = curList.remove(i);
            ans2 = recur(nums, cur, count + 1, N);
            curList.add(i, cur);
        }
        return Math.min(ans1, ans2);
    }
}
