package 剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/10
 */
public class _31_栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int cur : pushed) {
            stack.push(cur);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
