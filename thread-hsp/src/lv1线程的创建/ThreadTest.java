package lv1线程的创建;

/**
 * 线程的创建————继承Thread
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Slave s = new Slave();
        s.start();//启动线程

        //当main线程启动一个子线程Thread-0，主线程不会阻塞，会继续执行。jj
        //这时是并发。交替执行。
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            Thread.sleep(1000);
        }

    }
}

class Slave extends Thread {
    @Override
    public void run() {
        int times = 0;
        while (times <= 80) {
            System.out.println("Ryan :" + times + "线程名字 :" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                times++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
