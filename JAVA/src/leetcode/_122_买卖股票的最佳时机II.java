package leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/24
 */
public class _122_买卖股票的最佳时机II {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
