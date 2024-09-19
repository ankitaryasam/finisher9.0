package com.app.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("aroundAdvice")
@Aspect
public class MyArroundAdvice {
	
	
	private  Map<String, Object>  cacheMap = new HashMap<String, Object>();
	
	
	@Pointcut("execution(* com.app.service.BankService.*(..))")
	public void ptc() {
		// dummy method for pointcut
	}
	
	
	
	@Around("ptc()")
	@Order(7)
	public  Object  monitorPerformance(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("PerformanceMonitoringAroundAspect.monitorPerformance()");
		
		System.out.println("prelogic : PerformanceMonitoringAspect");
		//pre-logic
		long startTime = System.currentTimeMillis();
		
		//execute the target method
		Object returnedValue =pjp.proceed();
		
		//post-logic
		System.out.println("postlogic : PerformanceMonitoringAspect");
		long endTime = System.currentTimeMillis();
		
		System.out.println(pjp.getSignature() + " has taken " + 
							(endTime-startTime) +
							"ms" + " to execute");
		
		
		return returnedValue;
		
	}
	
	
	@Around("ptc()")
	@Order(2)
	public Object  logging(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("logging aspect  :  pre-logic");
		System.out.println("entering into " + pjp.getSignature() + " with args : " +
				                              Arrays.toString(pjp.getArgs())
				                                                     );
		
		Object retunedValue = pjp.proceed();
		
		System.out.println("logging aspect  : post logic");
		
		System.out.println("leaving from " + pjp.getSignature() + " with args : " +
                Arrays.toString(pjp.getArgs())
                                       );
		return retunedValue;
	}
	
	
    
	@Around("ptc()")
	@Order(9)
	public  Object  caching(ProceedingJoinPoint pjp) throws Throwable {
		
		
		System.out.println("caching aspect");
		
		String key = pjp.getSignature() + Arrays.toString(pjp.getArgs());
		
		Object returnedValue = null;
		
		if(!cacheMap.containsKey(key)) {
			System.out.println("caching aspect : pre logic");
			System.out.println("from the target method");
			returnedValue = pjp.proceed();
			System.out.println("caching aspect : post logic");
			cacheMap.put(key, returnedValue);
		}
		else {
			System.out.println("from the cache");
			returnedValue = cacheMap.get(key);
		}
		
		return returnedValue;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
