package lv1线程的创建;

/**
 * 线程的创建练习题：
 * 创建两个线程
 * 一个说 “Hello World”   10次 每次间隔1s
 * 一个说 “hi”            5次 每次间隔1s
 */

public class ThreadTest3 {
    public static void main(String[] args) {
        MyThread3 helloWorld = new MyThread3("Hello World", 10);
        MyThread3 hi = new MyThread3("hi", 5);
        helloWorld.start();
        hi.start();

    }


    public static class MyThread3 extends Thread {
        String context;
        int times;

        /**
         * @param context 想要在控制台输出的字符串
         * @param times   想要字符串出现的次数
         */
        public MyThread3(String context, int times) {
            this.context = context;
            this.times = times;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.times; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(context);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}

