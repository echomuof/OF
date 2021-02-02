package OKOFFER.stack_queue;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_如何仅用递归函数和栈操作逆序一个栈 {
    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int lowest = getLowest(stack);
        reverseStack(stack);
        stack.push(lowest);
    }

    public int getLowest(Stack<Integer> stack) {
        int ans = stack.pop();
        if (stack.isEmpty()) {
            return ans;
        } else {
            int lowest = getLowest(stack);
            stack.push(ans);
            return lowest;
        }
    }
}
