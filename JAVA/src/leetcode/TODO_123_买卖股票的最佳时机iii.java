package leetcode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2020/10/23
 */
public class TODO_123_买卖股票的最佳时机iii {
    public static void main(String[] args) throws IOException {
        System.out.println(new URL("https://vod.pipi.cn/fe5b84bcvodcq1251246104/cdae7eca5285890809032411479/f0.mp4").openConnection().getContentLengthLong());
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        Map<Key, Integer> map = new HashMap<>();
        return dfs(prices, 0, 0, 0, map);
    }

    public int dfs(int[] prices, int index, int status, int k, Map<Key, Integer> map) {
        if (index == prices.length || k == 2) return 0;
        Key key = new Key(index, status, k);
        if (map.containsKey(key)) return map.get(key);
        int a = 0, b = 0, c = 0;
        a = dfs(prices, index + 1, status, k, map);
        if (status == 1) {
            b = dfs(prices, index + 1, 0, k + 1, map) + prices[index];
        } else {
            c = dfs(prices, index + 1, 1, k, map) - prices[index];
        }
        int max = Math.max(a, Math.max(b, c));
        map.put(key, max);
        return max;
    }

    static class Key {
        int index;
        int status;
        int k;

        public Key(int index, int status, int k) {
            this.index = index;
            this.status = status;
            this.k = k;
        }
    }

}
