package com.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


// https://docs.spring.io/spring-framework/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html

@Component
@Aspect
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution(* com.app.service..*(..))")
	public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		
		logger.info("**** "+joinPoint.getTarget().getClass() +":" + joinPoint.getSignature().getName() + ": Before Method Execution");
		
		try {
			result = joinPoint.proceed();
		} finally {

		}
		
		logger.info("**** "+joinPoint.getTarget().getClass() +":" + joinPoint.getSignature().getName() + ": After Method Execution");
		
		return result;
	}

}
