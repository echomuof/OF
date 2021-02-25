package OKOFFER.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangdarui
 * @created: 2021/2/23
 */
public class 生产消费模型_Lock {
    public static void main(String[] args) {

        MyLockQueue myLockQueue = new MyLockQueue(10);

        new Thread(() -> {
            int i = 1000;
            while (i-- > 0) {
                myLockQueue.put(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            int i = 1000;
            while (i-- > 0) {
                myLockQueue.get();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}

class MyLockQueue {

    private ReentrantLock lock;

    private Condition putCondition;

    private Condition takeCondition;

    private List<Integer> list;

    private Integer size;

    public MyLockQueue(Integer size) {
        this.lock = new ReentrantLock();
        putCondition = lock.newCondition();
        takeCondition = lock.newCondition();
        list = new LinkedList<>();
        this.size = size;
    }

    public void put(Integer val) {
        try {
            lock.lock();
            if (list.size() == size) {
                putCondition.await();
            }
            System.out.println("put " + val);
            list.add(val);
            takeCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Integer get() {
        try {
            lock.lock();
            if (list.isEmpty()) {
                takeCondition.await();
            }
            Integer val = list.get(0);
            list.remove(0);
            System.out.println("take " + val);
            putCondition.signal();
            return val;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return -1;
    }


}
