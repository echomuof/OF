package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/15
 */
public class _70_爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 0; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
