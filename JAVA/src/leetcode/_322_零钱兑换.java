package leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/24
 */
public class _322_零钱兑换 {
    public static void main(String[] args) {
        _322_零钱兑换 a = new _322_零钱兑换();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(a.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int res = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > amount) {
                continue;
            }
            int cur = amount / coins[i];
            amount -= coins[i] * cur;
            res += cur;
        }
        return amount == 0 ? res : -1;
    }
}
