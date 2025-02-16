public class TestLamda2 {

    public static void main(String[] args) {
        //1. lamda表示简化
        ILove love = (int a) -> {
            System.out.println("I love you -->" + a);
        };

        //简化1：参数类型
        love = (a) -> {
            System.out.println("I love you -->" + a);
        };

        //简化2：简化括号
        love = a -> {
            System.out.println("I love you -->" + a);
        };

        //简化3：简化花括号
        love = a -> System.out.println("I love you -->" + a);

        love.love(520);
    }
}

interface ILove {
    void love(int a);
}
