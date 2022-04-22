package com.mulcam.aop.sample3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingSample {
	@Around("execution(* sayHello())")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
		String methodName = pjp.getSignature().getName();
		StopWatch sw= new StopWatch();
		sw.start(methodName);
		System.out.println("[LOG] METHOD: "+methodName+" is calling");
		Object object = pjp.proceed();
		sw.stop();
		System.out.println("[LOG] METHOD: "+methodName+" was called");
		System.out.println("[LOG] 처리시간 :"+sw.getTotalTimeSeconds()+"초");
		return object;
	}
}
