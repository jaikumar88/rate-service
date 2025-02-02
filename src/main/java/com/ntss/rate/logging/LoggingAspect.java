package com.ntss.rate.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {

	
	Logger logger = LoggerFactory.getLogger(this.getClass());
    @Around("execution(* com.ntss.rate.service.impl.EmployeeServiceImpl.*(..))")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
    
    // Log method arguments
    @Before("execution(* com.ntss.rate.controller.*.*(..))")
    public void logMethodArguments(JoinPoint joinPoint) {
    	System.out.println("Method {} called with arguments {} " + joinPoint.getSignature().toShortString() + joinPoint.getArgs());
        logger.info("Method {} called with arguments {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    } // Log method arguments
    
}
