public class StaticProxy {
    public static void main(String[] args) {
        //对比thread和静态代理
        You you = new You();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
        new Thread(() -> System.out.println("我爱你")).start();
        new WeddingCompany(new You()).HappyMarry();

        // 静态代理,是上面的完整版
//        WeddingCompany weddingCompany = new WeddingCompany(new You());
//        weddingCompany.HappyMarry();
    }
}


interface Marry{
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了!");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry {
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}