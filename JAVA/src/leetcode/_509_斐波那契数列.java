package leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/16
 */
public class _509_斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fib2(4));
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        return fib2(n - 1) + fib2(n - 2);
    }
}
