package com.arnab.spring11_springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);


//  @Advice(PointCut)
//  @Advice("execution(return type ,class-name.method-name(arguments)")

//  Log Before Method Called

    @Before("execution(* com.arnab.spring11_springaop.service.JobService.*(..))")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Method Called: "+jp.getSignature().getName());
    }

//  Log After Method Called

//  This will be called after method execution (whether there is an error or not)
    @After("execution(* com.arnab.spring11_springaop.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed: "+jp.getSignature().getName());
    }

//  This will be called if the method throw some error
    @AfterThrowing("execution(* com.arnab.spring11_springaop.service.JobService.*(..))")
    public void logMethodCrashed(JoinPoint jp){
        LOGGER.info("Method has some issue: "+jp.getSignature().getName());
    }

//  This will be called if the method executed without any error
    @AfterReturning("execution(* com.arnab.spring11_springaop.service.JobService.*(..))")
    public void logMethodSuccess(JoinPoint jp){
        LOGGER.info("Method Executed Successfully: "+jp.getSignature().getName());
    }
}