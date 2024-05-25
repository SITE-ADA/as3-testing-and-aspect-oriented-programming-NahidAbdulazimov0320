package com.demo.springboot.assignment_three.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.demo.springboot.assignment_three.services.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // Log method input parameters
        logger.info("Entering method: {} with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());

        Object result;

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            logger.error("Exception in method: {} with cause: {}", joinPoint.getSignature(), e.getCause() != null ? e.getCause() : "NULL");
            throw e;
        }

        // Log method return value and execution time
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Exiting method: {} with result: {} | Execution time: {} ms", joinPoint.getSignature(), result, timeTaken);

        return result;
    }
}
