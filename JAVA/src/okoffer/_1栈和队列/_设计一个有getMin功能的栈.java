package okoffer._1栈和队列;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/9
 */
public class _设计一个有getMin功能的栈 {
    public static void main(String[] args) {

    }
}

class MinStack {
    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(x < minStack.peek() ? x : minStack.peek());
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