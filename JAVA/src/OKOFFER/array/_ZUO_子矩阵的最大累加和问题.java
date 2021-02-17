package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_子矩阵的最大累加和问题 {
    public static int maxSumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] s = new int[matrix[i].length];
            for (int j = i; j < matrix.length; j++) {
                int cur = 0;
                for (int k = 0; k < matrix[j].length; k++) {
                    s[k] += matrix[j][k];
                    cur += s[k];
                    ans = Math.max(ans, cur);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return ans;
    }
}
