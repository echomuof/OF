package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _59_ii_队列的最大值 {
}

class MaxQueue {

    private Queue<Integer> queue;

    private Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) maxQueue.pollLast();
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        Integer pop = queue.poll();
        if (pop.equals(maxQueue.peekFirst())) maxQueue.pollFirst();
        return pop;
    }
}
