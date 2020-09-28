package 剑指offer;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _9_用两个栈实现队列 {

}

class CQueue {

    public Stack<Integer> s1;
    public Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }
}
