package cn.itcast.test.aop;

import org.springframework.stereotype.Component;

@Component
public class Target implements TargetInterFace{
    public void show() {
        System.out.println("show   ......");
    }
}
