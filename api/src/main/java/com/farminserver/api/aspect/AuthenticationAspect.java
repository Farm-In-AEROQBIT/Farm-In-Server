package com.farminserver.api.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {
    @Around("execution(* com.farminserver.api.service.AuthenticationService(..))")
    public Object aroundAuthenticate(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("Before authentication: " + joinPoint.getSignature());
            return joinPoint.proceed();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError caught: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("After authentication: " + joinPoint.getSignature());
        }
    }}
