/**
 * 推导lamda表达式
 */
public class TestLamda {
    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lamda() {
            System.out.println("i like lamda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lamda();

        like = new Like2();
        like.lamda();

        //4.局部内部类
        class Like3 implements ILike {
            @Override
            public void lamda() {
                System.out.println("i like lamda3");
            }
        }
        like = new Like3();
        like.lamda();

        //匿名内部类,没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lamda() {
                System.out.println("i like lamda4");
            }
        };
        like.lamda();

        //6.用lamda简化
        like = () -> {
            System.out.println("i like lamda5");
        };
        like.lamda();

    }
}

//1.定义一个函数式接口
interface ILike{
    void lamda();
}

//2.实现类
class Like implements ILike{
    @Override
    public void lamda() {
        System.out.println("i like lamda1");
    }
}

