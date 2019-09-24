package cn.itcast.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        final Target target = new Target();
        final Advice advice = new Advice();

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(Target.class.getClassLoader(), Target.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.before123();
                Object invoke = method.invoke(target);
                advice.afterRunning123();
                return invoke;
            }
        });
        proxy.show();
    }
}
