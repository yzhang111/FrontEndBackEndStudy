package com.yzhan101.reflection;

//什么叫反射
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("com.yzhan101.reflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("com.yzhan101.reflection.User");
        Class c3 = Class.forName("com.yzhan101.reflection.User");
        Class c4 = Class.forName("com.yzhan101.reflection.User");


        //一个类再内存中只有一个Class对象
        //一个类被加载后

        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());

    }
}

// 实体类: pojo, entity
class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
