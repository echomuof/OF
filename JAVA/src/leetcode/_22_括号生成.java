package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @date: 2020/9/21
 */
public class _22_括号生成 {
    public static void main(String[] args) {
        generateParenthesis(3).stream().forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        process(n, n, n, "",res);
        return res;
    }

    public static void process(int n, int left, int right, String s, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            process(n - 1, left - 1, right, s + "(", res);
        }
        if (right > left) {
            process(n - 1, left, right - 1, s + ")", res);
        }
    }
}
