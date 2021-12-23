package com.example.demo.loadclass;

import java.lang.reflect.Method;

/**
 * Create By Gq
 * 2021/6/8 下午2:41
 */
public class LoadClassTest {
    /**
     *  1.使用new、获取静态变量、设置静态变量和执行静态方法的时候会初始化
     *  2.类在初始化时，其父类没有初始化会先初始化其父类
     *  3.虚拟机启动时会初始化带有main方法的类
     *  4.对类使用反射时会先初始化该类
     *
     */

    static {
        System.out.println("----------- LoadClassTest init ------------");
    }

    public static void main(String[] args) {
        //获取类的静态成员变量时会初始化该类,并且父类在未初始化时也初始化其父类
//        System.out.println(Children.CHILDREN_VALUE);

        //通过反射调用会导致类初始化
        try {
            Class<?> aClass = Class.forName("com.example.demo.loadclass.Children");
            Object o = aClass.newInstance();
            Method declaredMethod = aClass.getDeclaredMethod("getChildValue", null);
            String invoke = (String) declaredMethod.invoke(o);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
