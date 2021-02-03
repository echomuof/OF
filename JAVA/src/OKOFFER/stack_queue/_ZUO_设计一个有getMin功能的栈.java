package OKOFFER.stack_queue;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/1/28
 */
public class _ZUO_设计一个有getMin功能的栈 {


}

class MyStack {
    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public MyStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(Integer value) {
        stack.push(value);
        minStack.push((minStack.isEmpty() || minStack.peek() >= value) ? value : minStack.peek());
    }

    public Integer pop() {
        if (stack.isEmpty()) return -1;
        minStack.pop();
        return stack.pop();
    }

    public Integer getMin() {
        return minStack.peek();
    }
}
