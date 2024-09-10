package com.app.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//Aspect class or Advice class
public class PerformanceMonitoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("PerformanceMonitoringAdvice.invoke()");
		
		//pre-logic
		System.out.println("pre-logic :: invoke()");
		long startTime = System.currentTimeMillis();
		
		Object returnedValue = invocation.proceed();
		
		// post-logic
		long endTime = System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()
				 + " method has taken " + 
				    (endTime - startTime) +
				    "ms to complete its execution"
				);
		
		
	
		System.out.println("post-logic :: invoke()");
		
		return returnedValue;
		
	}
	
	
	

}
