package leetcode;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @date: 2020/9/24
 */
public class TODO_322_零钱兑换 {
    public static void main(String[] args) {
        TODO_322_零钱兑换 a = new TODO_322_零钱兑换();
        int[] coins = {2, 5, 10, 1};
        int amount = 27;
        System.out.println(a.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
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
