package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/9/28
 */
public class _17_打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int sq = 1;
        for (int i = 1; i <= n; i++) {
            sq *= 10;
        }
        int[] ans = new int[sq - 1];
        for (int i = 0; i < sq - 1; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
