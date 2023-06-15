package com.learn.timezone.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before(value = "execution(* com.learn.timezone.service..* (..))")
	public void beforeExecution(JoinPoint joinPoint) {
		System.out.println("Before method:" + joinPoint.getSignature());
	}
	
	@After(value = "execution(* com.learn.timezone.service..* (..))")
	public void afterExecution(JoinPoint joinPoint) {
		System.out.println("After method:" + joinPoint.getSignature());
	}
	
	@Around(value = "execution(* com.learn.timezone.service..* (..))")
	public void aroundExecution(JoinPoint joinPoint) {
		System.out.println("Around  method:" + joinPoint.getSignature());
	}
}
