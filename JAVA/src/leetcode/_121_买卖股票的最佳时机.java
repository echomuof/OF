package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/22
 */
public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) min = price;
            else if (price - min > max) max = price - min;
        }
        return max;
    }
}
