package OKOFFER.stack_queue;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_如何仅用递归函数和栈操作逆序一个栈 {

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        Integer lowest = getLowest(stack);
        reverseStack(stack);
        stack.push(lowest);
    }

    public Integer getLowest(Stack<Integer> stack) {
        Integer cur = stack.pop();
        if (stack.isEmpty()) return cur;
        Integer lowest = getLowest(stack);
        stack.push(cur);
        return lowest;
    }
}
