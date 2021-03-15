package OKOFFER.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author: wangdarui
 * @created: 2021/2/25
 */
public class 生产消费模型_Semaphore {
    public static void main(String[] args) {

        MySemaphoreQueue mySemaphoreQueue = new MySemaphoreQueue(10);

        new Thread(() -> {
            int i = 1000;
            while (i-- > 0) {
                mySemaphoreQueue.put(i);
                // try {
                //     Thread.sleep(1);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            }
        }).start();

        new Thread(() -> {
            int i = 1000;
            while (i-- > 0) {
                mySemaphoreQueue.take();
                // try {
                //     Thread.sleep(1);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            }
        }).start();
    }
}

class MySemaphoreQueue {

    private Semaphore putSemaphore;

    private Semaphore takeSemaphore;

    private Semaphore mutexSemaphore;

    private List<Integer> list;

    private Integer size;

    public MySemaphoreQueue(Integer size) {
        this.size = size;
        this.list = new LinkedList<>();
        this.putSemaphore = new Semaphore(size);
        this.takeSemaphore = new Semaphore(0);
        this.mutexSemaphore = new Semaphore(1);
    }

    public void put(Integer val) {
        try {
            putSemaphore.acquire();
            mutexSemaphore.acquire();
            list.add(val);
            System.out.println("put " + val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutexSemaphore.release();
            takeSemaphore.release();
        }
    }

    public Integer take() {
        try {
            takeSemaphore.acquire();
            mutexSemaphore.acquire();
            Integer val = list.remove(0);
            System.out.println("take " + val);
            return val;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutexSemaphore.release();
            putSemaphore.release();
        }
        return -1;
    }
}
