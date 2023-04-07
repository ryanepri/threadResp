package lv2售票系统引发的问题及解决方案;

public class SellTicketAnswer {
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
            while (ticket > 0) {
                System.out.println(ticket--);
            }
        }
    }

    static class T2 extends Thread {
        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(ticket--);
            }
        }
    }

    static class T3 extends Thread {
        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(ticket--);
            }
        }
    }
}
