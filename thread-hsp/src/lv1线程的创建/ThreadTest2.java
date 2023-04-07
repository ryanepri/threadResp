package lv1线程的创建;

/**
 * 线程的创建————实现Runnable接口
 */
public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
//        lv1线程的创建.Cat cat = new lv1线程的创建.Cat();
//        cat.start();
//        Thread thread = new Thread(cat);
//        thread.start();

        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();

        //main线程
        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000);
            System.out.println(i + "----" + Thread.currentThread().getName());
        }
    }
}


/**
 * 代理模式的模拟
 * //Proxy 代理。
 * //这里只是一种模型。并没有被真正实现。
 */
class ThreadProxy implements Runnable {//ThreadProxy线程代理。
    private Runnable target = null;

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    //构造器里接收实现了Runnable接口的对象
    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();//
    }

    public void start0() {
        run();
    }
}

class Cat implements Runnable {
    @Override
    public void run() {
        int times = 0;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                times++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(times + "--喵喵喵--" + Thread.currentThread().getName());
        }

    }

}

class Tiger implements Runnable {
    @Override
    public void run() {
        int times = 0;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                times++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(times + "--嗷嗷嗷--" + Thread.currentThread().getName());
        }

    }

}
