package cn.itcast.test.proxy.cglib;

public class Advice {

    public void before123(){
        System.out.println("前值增强   ......");
    }

    public void afterRunning123(){
        System.out.println("后值增强   ......");
    }

    public void around123(){
        System.out.println("环绕方法   ......");
    }
}
