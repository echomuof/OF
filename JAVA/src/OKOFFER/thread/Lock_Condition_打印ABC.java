package OKOFFER.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class Lock_Condition_打印ABC {

    private static ReentrantLock lock;

    private static Condition conditionA;

    private static Condition conditionB;

    private static Condition conditionC;

    private static int count = 0;

    public static void main(String[] args) {
        lock = new ReentrantLock();
        conditionA = lock.newCondition();
        conditionB = lock.newCondition();
        conditionC = lock.newCondition();

        Thread tA = new Thread(new A());
        Thread tB = new Thread(new B());
        Thread tC = new Thread(new C());

        tA.start();
        tB.start();
        tC.start();

    }

    static class A implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    if (count % 3 != 0) {
                        conditionA.await();
                    }
                    System.out.println("A " + i);
                    count++;
                    conditionB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    if (count % 3 != 1) {
                        conditionB.await();
                    }
                    System.out.println("B " + i);
                    count++;
                    conditionC.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    static class C implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    if (count % 3 != 2) {
                        conditionC.await();
                    }
                    System.out.println("C " + i);
                    count++;
                    conditionA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

}





























