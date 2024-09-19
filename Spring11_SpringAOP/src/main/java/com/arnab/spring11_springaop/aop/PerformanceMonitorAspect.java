package com.arnab.spring11_springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);

//  Log Around Method Called

//  Method to monitor execution time
    @Around("execution(* com.arnab.spring11_springaop.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
//      Before Method Call
        long start=System.currentTimeMillis();

        Object obj=jp.proceed(); // Method Calling

//      After Method Called
        long end=System.currentTimeMillis();

        LOGGER.info("Time taken - " + (end-start)+" ms " + jp.getSignature().getName());
        return obj;
    }
}
