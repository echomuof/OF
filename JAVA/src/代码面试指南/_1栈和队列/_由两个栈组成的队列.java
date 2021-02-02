package 代码面试指南._1栈和队列;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/9
 */
public class _由两个栈组成的队列 {

}

class CQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

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