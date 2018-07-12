package com.adrianbarczuk.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
			
	//pointcut declarations
	@Pointcut("execution(* com.adrianbarczuk.springdemo.controller.*.*(..))")
	private void controllerPackage() {}
	
	@Pointcut("execution(* com.adrianbarczuk.springdemo.service.*.*(..))")
	private void servicePackage() {}
	
	@Pointcut("execution(* com.adrianbarczuk.springdemo.dao.*.*(..))")
	private void daoPackage() {}
	
	@Pointcut("controllerPackage() || servicePackage() || daoPackage()")
	private void appFlow() {}
	
	//@Before advice
	@Before("appFlow()")
	public void before(JoinPoint joinPoint) {
		
		//display method signature
		String method = joinPoint.getSignature().toShortString();
		logger.info("@Before From method: " + method);
		
		//display methods arguments
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			logger.info("Argument: " + object);
		}
	}
	
	//@AfterReturning advice
	@AfterReturning(
			pointcut="appFlow()",
			returning="result")
	public void afterReturnig(JoinPoint joinPoint, Object result) {
		
		//display method signature 
		String method = joinPoint.getSignature().toShortString();
		logger.info("@AfterReturning From method: " + method);
		
		//display data returned
		logger.info("Result: " + result);
	}

}
