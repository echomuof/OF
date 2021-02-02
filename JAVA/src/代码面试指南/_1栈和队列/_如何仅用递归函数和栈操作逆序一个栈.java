package 代码面试指南._1栈和队列;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/9
 */
public class _如何仅用递归函数和栈操作逆序一个栈 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        Integer cur = stack.pop();
        if (stack.isEmpty()) {
            return cur;
        }
        int result = getAndRemoveLastElement(stack);
        stack.push(cur);
        return result;
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }

}
