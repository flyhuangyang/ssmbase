package com.ssm.aop;

import com.sun.javafx.collections.VetoableListDecorator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hy
 * @create 2018/12/13 0013
 * @description
 */

@Aspect
public class TestAop {

    // 指定切入点表达式： 拦截哪些方法； 即为哪些类生成代理对象
    @Pointcut("execution(* com.ssm.aop.Test.*(..))")
    public void  pointcut_(){
        System.out.println("切入点");
    }

    // 前置通知 : 在执行目标方法之前执行
//    @Before("execution(* com.ssm.aop.Test.*(..))")   //其中execution(* com.ssm.aop.Test.*(..))等效于上面定义的ponitcut_()切入点
    @Before("pointcut_()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置方法");
    }

    // 后置/最终通知：在执行目标方法之后执行  【无论是否出现异常最终都会执行】
    @After("execution(* com.ssm.aop.Test.*(..))")
    public void after() {
        System.out.println("后置方法");
    }

    // 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
    @AfterReturning("pointcut_()")
    public void afterReturning(){
        System.out.println("afterreturning");
    }

    // 异常通知： 当目标方法执行异常时候执行此关注点代码
    @AfterThrowing("pointcut_()")
    public void afterThrowing(){
        System.out.println("aftgerthrowing");
    }

    // 环绕通知：环绕目标方式执行
    @Around("pointcut_()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕前....");
        pjp.proceed();  // 执行目标方法
        System.out.println("环绕后....");
    }

}
