package 算法面试汇总;

/**
 * @author: wangdarui
 * @created: 2020/11/26
 */
public class LC搜索二维矩阵ii {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[i].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
