package cn.itcast.test.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(final String[] args) {
        final Target target = new Target();
        final Advice advice = new Advice();

        // 动态生成代理对象，基于cglib
        // 1.创建增强器
        Enhancer enhancer = new Enhancer();
        // 2.设置父类（目标）
        enhancer.setSuperclass(Target.class);
        // 3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 执行前置
                advice.before123();
                // 执行目标
                Object invoke = method.invoke(target, args);
                // 执行后置
                advice.afterRunning123();
                return invoke;
            }
        });
        // 4.生成代理对象
        Target proxy = (Target) enhancer.create();

        proxy.show();
    }
}
