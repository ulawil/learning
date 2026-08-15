package com.uleczka.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderLoggingAspect {

    @Pointcut("execution(* com.uleczka.service.OrderService.*(..))")
    public void orderServiceMethods() {
    }

    @Before("orderServiceMethods()")
    public void logBefore() {
        System.out.println("Calling OrderService method");
    }

    @Around("orderServiceMethods()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println(joinPoint.getSignature().getName() + " took " + (end - start) + " ms");

        return result;
    }

    @AfterReturning(pointcut = "orderServiceMethods()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("Returned: " + result);
    }

    @AfterThrowing(pointcut = "orderServiceMethods()", throwing = "exception")
    public void afterThrowing(Exception exception) {
        System.out.println("Method threw: " + exception.getMessage());
    }
}
