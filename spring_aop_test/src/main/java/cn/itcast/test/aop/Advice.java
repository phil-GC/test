package cn.itcast.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {

    @Before("pointcut()")
    public void before123(){
        System.out.println("前值增强   ......");
    }

    @AfterReturning("pointcut()")
    public void afterReturning123(){
        System.out.println("后值增强   ......");
    }

    @Around("pointcut()")
    public Object around123(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前   ......");
        Object proceed = pjp.proceed();
        System.out.println("环绕后   ......");
        return proceed;

    }

    @AfterThrowing("pointcut()")
    public void afterThrowing123(){
        System.out.println("产生错误   ......");
    }

    @After("pointcut()")
    public void after123(){
        System.out.println("最终方法   ......");
    }

    @Pointcut("execution(* cn.itcast.test.aop.*.*(..))")
    public void pointcut(){}
}
