package okoffer._1栈和队列;

import javax.xml.stream.events.StartDocument;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/9
 */
public class _用一个栈实现另一个栈的排序 {
    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(1);
        sortedStack.push(2);
        System.out.println(sortedStack.peek());
        sortedStack.pop();
        System.out.println(sortedStack.peek());
    }

    /**
     * 对栈进行排序
     *
     * @param stack
     */
    public static void sortedStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}

class SortedStack {

    private Stack<Integer> stack;
    private Stack<Integer> help;

    public SortedStack() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || stack.peek() >= val) {
            stack.push(val);
            return;
        }
        while (!stack.isEmpty() && stack.peek() < val) {
            help.push(stack.pop());
        }
        stack.push(val);
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

