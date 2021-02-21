package OKOFFER.thread;

/**
 * @author: wangdarui
 * @created: 2021/2/22
 */
public class 两个线程交替打印1到10 {
    static int count = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (count < 10) {
                    synchronized (this.getClass()) {
                        this.getClass().notify();
                        System.out.println(Thread.currentThread().getName() + " " + count);
                        count++;
                        try {
                            this.getClass().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        new Thread(runnable, "线程A").start();
        new Thread(runnable, "线程B").start();
    }
}
