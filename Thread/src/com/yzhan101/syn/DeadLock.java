package com.yzhan101.syn;

//死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(1, "白雪公主");

        g1.start();
        g2.start();
    }
}

//口红
class Lipstick{

}

//镜子
class Mirror{

}

class Makeup extends Thread{
    //需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            this.makeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {//获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
//                synchronized (mirror) {
//                    System.out.println(this.girlName + "获得镜子的锁");
//                }
            }
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
            }
        } else {
            synchronized (mirror) {//获得口红的锁
                System.out.println(this.girlName + "获得镜子的锁");
                Thread.sleep(1000);
//                synchronized (lipstick) {
//                    System.out.println(this.girlName + "获得口红的锁");
//                }
            }
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
            }
        }
    }
}