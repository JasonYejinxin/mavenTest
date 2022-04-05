package aopAnnoTest.aopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect //生成代理对象
@Order(2)
public class UserProxy {

    @Pointcut(value = "execution(* aopAnnoTest.aopAnno.User.add(..))")
    public void pointdemo (){
    }


    //@Before注解表示作为前置通知
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before...");
    }
    @After(value = "execution(* aopAnnoTest.aopAnno.User.add(..))")
    public void after(){
        System.out.println("after...");
    }
    @AfterReturning(value = "execution(* aopAnnoTest.aopAnno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }
    @AfterThrowing(value = "execution(* aopAnnoTest.aopAnno.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }
    @Around(value = "execution(* aopAnnoTest.aopAnno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("around1...");
        proceedingJoinPoint.proceed();
        System.out.println("around2...");
    }
}
