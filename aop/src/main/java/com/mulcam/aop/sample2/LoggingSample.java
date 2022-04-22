package com.mulcam.aop.sample2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingSample {
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
