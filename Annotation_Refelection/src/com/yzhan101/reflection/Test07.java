package com.yzhan101.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类的加载器的父类加载器-->扩展类加载类
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取拓展类加载器的父类加载器-->根加载器(C/c++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.yzhan101.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);
    }
}
