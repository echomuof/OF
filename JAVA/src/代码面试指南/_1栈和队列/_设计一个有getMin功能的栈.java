package 代码面试指南._1栈和队列;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/9
 */
public class _设计一个有getMin功能的栈 {
    public static void main(String[] args) {
        String s3 = new String("l") + new String("l");
        String s4 = "ll";
        s3 = s3.intern();
        System.out.println(s3 == s4);

        MinStack minStack = new MinStack();
    }
}

class MinStack implements Cloneable{
    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            val = Math.min(minStack.peek(), val);
        }
        minStack.push(val);
    }

    public Integer pop() {
        minStack.pop();
        return stack.isEmpty() ? -1 : stack.pop();
    }

    public Integer getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}