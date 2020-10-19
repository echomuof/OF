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

    public static int getMaxMoney(int[][] income) {
        recur(income, 0, 0, 0, 0, income.length / 2, new int[income.length]);
        return ans;
    }

    static int ans = Integer.MIN_VALUE;

    public static void recur(int[][] income, int A, int B, int index, int cur, int m, int[] hasVisit) {
        if (A == m && B == m) {
            ans = Math.max(ans, cur);
            return;
        }
        for (int i = index; i < income.length; i++) {
            if (hasVisit[i] == 1) continue;
            hasVisit[i] = 1;
            if (A < m) recur(income, A + 1, B, i, cur + income[i][0], m, hasVisit);
            if (B < m) recur(income, A, B + 1, i, cur + income[i][1], m, hasVisit);
            hasVisit[i] = 0;
        }
    }

    public static int func(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(i + 1 - nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] scores = {7, 6, 5, 1, 3};
        System.out.println(func3(scores));
        int[] s = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(func2(s, 4, 4));
    }

    public static int func2(int[] scores, int x, int y) {
        if (scores == null || scores.length == 0) return 0;
        Arrays.sort(scores);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            map.put(scores[i], i);
        }
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = scores[0]; i <= scores[scores.length - 1]; i++) {
            int cur = i;
            while (!map.containsKey(cur) && cur >= 0) {
                cur--;
            }
            if (cur == -1) continue;
            index.put(i, map.get(cur));
        }

        for (Map.Entry<Integer, Integer> entry : index.entrySet()) {
            Integer i = entry.getValue();
            if (i + 1 >= x && scores.length - i - 1 <= y) return entry.getKey();
        }
        return -1;
    }

    public static int func3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int ans = 0;
        list.sort(Comparator.comparingInt(o -> o));
        while (list.size() > 1) {
            int a = list.remove(0);
            int b = list.remove(0);
            ans += a * b;
            list.add(a + b);
            list.sort(Comparator.comparingInt(o -> o));
        }
        return ans;
    }

}



























