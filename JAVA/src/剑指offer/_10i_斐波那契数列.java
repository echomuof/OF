package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _10i_斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fib(7));
    }

    public static int fib(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = a + b;
        n -= 2;
        while (n-- > 0) {
            a = b % 1000000007;
            b = c % 1000000007;
            c = (a + b) % 1000000007;
        }
        return c;
    }
}
