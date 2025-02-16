public class TestYield {
    public static void main(String[] args) {
        MyField myField = new MyField();

        new Thread(myField, "a").start();
        new Thread(myField, "b").start();
    }
}

class MyField implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程结束执行");
    }
}