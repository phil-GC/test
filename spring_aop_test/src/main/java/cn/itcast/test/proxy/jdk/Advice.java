package cn.itcast.test.proxy.jdk;

public class Advice {

    public void before123(){
        System.out.println("前值增强   ......");
    }

    public void afterRunning123(){
        System.out.println("后值增强   ......");
    }
}
