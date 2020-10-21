package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/21
 */
public class TODO_322_零钱兑换 {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        if (amount<1) return 0;
        return recur(coins, amount, new int[amount]);
    }

    public int recur(int[] coins, int cur, int[] count) {
        if (cur < 0) return -1;
        if (cur == 0) return 0;
        if (count[cur - 1] != 0) return count[cur - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = recur(coins, cur - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[cur - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[cur - 1];
    }
}
