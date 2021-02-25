package OKOFFER.thread;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2021/2/23
 */
public class 生产消费模型_Synchronized {
    public static void main(String[] args) {
        MySyncQueue mySyncQueue = new MySyncQueue(10);

        new Thread(() -> {
            int i = 1000;
            while (i-- > 0) {
                mySyncQueue.put(i);
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
                mySyncQueue.take();
                // try {
                //     Thread.sleep(1);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            }
        }).start();
    }
}

class MySyncQueue {

    private int size;

    private List<Integer> list;

    public MySyncQueue(int size) {
        this.size = size;
        this.list = new LinkedList<>();
    }

    public void put(Integer val) {
        try{
            synchronized (this) {
                while (list.size() == this.size) {
                    this.wait();
                }
                this.list.add(val);
                System.out.println("put " + val);
                this.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int take() {
        try {
            synchronized (this){
                while (list.size() == 0) {
                    this.wait();
                }
                Integer val = this.list.get(0);
                this.list.remove(0);
                System.out.println("take " + val);
                this.notifyAll();
                return val;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
