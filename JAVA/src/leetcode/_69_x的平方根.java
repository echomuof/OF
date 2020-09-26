package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/26
 */
public class _69_x的平方根 {
    public static void main(String[] args) {
        _69_x的平方根 a = new _69_x的平方根();
        System.out.println(a.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
