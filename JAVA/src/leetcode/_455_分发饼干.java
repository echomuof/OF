package leetcode;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @date: 2020/9/24
 */
public class _455_分发饼干 {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int res = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return res;
    }
}
