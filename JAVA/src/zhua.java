/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class zhua {
    public static void main(String[] args) {
        int[][] income = {{10, 20}, {20, 40}};
        System.out.println(getMaxMoney(income));
    }

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
}
