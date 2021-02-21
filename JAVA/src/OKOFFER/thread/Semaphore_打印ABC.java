package OKOFFER.thread;

import java.util.concurrent.Semaphore;

/**
 * @author: wangdarui
 * @created: 2021/2/21
 */
public class Semaphore_打印ABC {
    private static Semaphore semaphoreA;

    private static Semaphore semaphoreB;

    private static Semaphore semaphoreC;

    public static void main(String[] args) {
        semaphoreA = new Semaphore(1);
        semaphoreB = new Semaphore(0);
        semaphoreC = new Semaphore(0);

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
                for (int i = 0; i < 10; i++) {
                    semaphoreA.acquire();
                    System.out.println("A " + i);
                    semaphoreB.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreB.acquire();
                    System.out.println("B " + i);
                    semaphoreC.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class C implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreC.acquire();
                    System.out.println("C " + i);
                    semaphoreA.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
