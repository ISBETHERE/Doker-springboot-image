package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlerAspect {

    @AfterThrowing(pointcut = "execution(* com.example.demo.HomeController.*(..))", throwing = "exception")
    public void handleError(JoinPoint joinPoint, Throwable exception) {
        System.out.println("오류 발생: " + joinPoint.getSignature().toShortString() + ", 예외: " + exception);
        // 여기에 HomeController에서 발생한 오류를 추적하고 관리하는 코드를 작성하세요.
    }
}