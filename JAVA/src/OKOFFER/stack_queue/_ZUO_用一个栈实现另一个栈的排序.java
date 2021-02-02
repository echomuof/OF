package OKOFFER.stack_queue;

import sun.jvm.hotspot.utilities.soql.JSJavaTypeArray;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_用一个栈实现另一个栈的排序 {
    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
