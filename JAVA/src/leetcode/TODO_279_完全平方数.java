package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/11/5
 *
 */
public class TODO_279_完全平方数 {

    public static void main(String[] args) {
        TODO_279_完全平方数 a = new TODO_279_完全平方数();
        System.out.println(a.numSquares(12));
    }

    public int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (checkSquare(i)) nums.add(i);
        }
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            ans += n / nums.get(i);
            n %= nums.get(i);
        }
        return ans;
    }

    public boolean checkSquare(int num) {
        if (num == 0 || num == 1) return true;
        long l = 2;
        long r = num;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid < num) l = mid + 1;
            else r = mid - 1;
        }
        return false;

    }

}
