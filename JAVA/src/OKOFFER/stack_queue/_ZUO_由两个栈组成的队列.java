package OKOFFER.stack_queue;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_由两个栈组成的队列 {
    public static void main(String[] args) {
        CQueue myQueue = new CQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }
}

class CQueue {
    private Stack<Integer> s1;

    private Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void add(Integer val) {
        s1.push(val);
    }

    public Integer poll() {
        move();

        return s2.pop();
    }

    public Integer peek() {
        move();
        return s2.peek();
    }

    private void move() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}
