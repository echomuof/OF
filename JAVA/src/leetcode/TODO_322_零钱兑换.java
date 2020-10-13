package leetcode;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @date: 2020/9/24
 */
public class TODO_322_零钱兑换 {
    public static void main(String[] args) {
        TODO_322_零钱兑换 a = new TODO_322_零钱兑换();
        int[] coins = {1};
        int amount = 0;
        System.out.println(a.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount==0) return amount;
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int cur = amount / coins[i];
            amount -= cur * coins[i];
            count += cur;
            amount %= coins[i];
        }
        return count == 0 || amount != 0 ? -1 : count;
    }
}
