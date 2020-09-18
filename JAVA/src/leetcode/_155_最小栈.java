package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangdarui
 * @created: 2020/9/17
 */
public class _155_最小栈 {

}

class MinStack {

    private Deque<Integer> stack = null;
    private Deque<Integer> minStack = null;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
