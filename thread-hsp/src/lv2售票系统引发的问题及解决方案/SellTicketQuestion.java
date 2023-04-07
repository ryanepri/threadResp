package lv2售票系统引发的问题及解决方案;

/**
 * 触发了线程问题
 */
public class SellTicketQuestion {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        t1.start();
        t2.start();
        t3.start();
    }

    static int ticket = 100;

    static class T1 extends Thread {
        @Override
        public void run() {
            Thread.currentThread().setName("A窗口");
            while (true) {
                if (ticket <= 0) {
                    break;
                }
                try {
                    sleep(50);
                    System.out.println(Thread.currentThread().getName() + "  ==  " + ticket--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    static class T2 extends Thread {
        @Override
        public void run() {
            Thread.currentThread().setName("B窗口");
            while (true) {
                if (ticket <= 0) {
                    break;
                }
                try {
                    sleep(50);
                    System.out.println(Thread.currentThread().getName() + "  ==  " + ticket--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class T3 extends Thread {
        @Override
        public void run() {
            Thread.currentThread().setName("C窗口");
            while (true) {
                if (ticket <= 0) {
                    break;
                }
                try {
                    sleep(50);
                    System.out.println(Thread.currentThread().getName() + "  ==  " + ticket--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
