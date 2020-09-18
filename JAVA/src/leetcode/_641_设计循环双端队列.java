package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/18
 */
public class _641_设计循环双端队列 {
}

class MyCircularDeque {

    private int[] queue;

    int front;

    int last;

    int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        queue = new int[k];
        front = 0;
        last = 0;
        size = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == queue.length) {
            return false;
        }
        if (front == 0) {
            front = queue.length - 1;
            queue[front] = value;
        } else {
            queue[--front] = value;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == queue.length) {
            return false;
        }
        queue[last] = value;
        last = last == queue.length - 1 ? 0 : last + 1;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        front = front == queue.length - 1 ? 0 : front + 1;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        last = last == 0 ? queue.length - 1 : last - 1;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return size == 0 ? -1 : queue[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return size == 0 ? -1 : (last == 0 ? queue[queue.length - 1] : queue[last - 1]);
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == queue.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */