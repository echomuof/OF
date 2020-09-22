package leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/21
 */
public class _50_PowXN {

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        return process(x, n);
    }

    public double process(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = process(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

}
