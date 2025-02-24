//上帝守护你
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You1 you = new You1();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认false表示的是用户线程，正常的线程都是用户线程

        thread.start();//上帝守护线程启动

        new Thread(you).start();//你 用户线程启动
    }
}

//上帝
class God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑你");
        }
    }
}

//你
class You1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("-====goodby!world!====-");
    }
}
