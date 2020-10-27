package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/27
 */
public class _518_零钱兑换ii {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
