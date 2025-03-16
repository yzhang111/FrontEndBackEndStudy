package main.java.com.yzhan101.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//懒汉式单例
public class LazyMan {
    private LazyMan() {
        System.out.println(Thread.currentThread().getName() + "ok");
    }
    private static LazyMan lazyMan;

    // 双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance() {
        if(lazyMan == null) {
            synchronized (LazyMan.class) {
                if(lazyMan == null) {
                    lazyMan = new LazyMan(); //不是一个原子操作
                    /**
                     * 1. 分配内存空间
                     * 2. 执行构造方法，初始化对象
                     * 3. 把这个对象指向这个空间
                     *
                     * 123 想要
                     * 132 A 也可能是
                     *     B //此时LazyMan还没有完成构造
                     */
                }
            }}
        return lazyMan;
    }

    // 多线程并发
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LazyMan.getInstance();
//            }).start();
//        }
//    }

    //反射
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(instance2);
    }
}
