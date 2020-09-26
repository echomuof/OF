package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/26
 */
public class _367_有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        long l = 2;
        long r = num / 2;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}

