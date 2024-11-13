package com.itheima;

import org.junit.Test;

import java.util.logging.Logger;

public class HelloWorld {
    public static void main(String[] args) {
        Logger logger;
        System.out.println("第一次尝试配置maven,maven的生命周期如下：");
        System.out.println("clean：清理");
        System.out.println("compile：编译");
        System.out.println("test：测试");
        System.out.println("package：打包");
        System.out.println("install：安装");
    }

    @Test
    public void test1() {
        System.out.println("111");
    }

    @Test
    public void test2() {
        System.out.println("222");
    }

    @Test
    public void test3() {
        System.out.println("333");
    }
}
