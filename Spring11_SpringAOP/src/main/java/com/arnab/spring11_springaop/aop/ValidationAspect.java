package com.arnab.spring11_springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(ValidationAspect.class);

    //  Log Around Method Called

    //  Method to validate inputs
    @Around("execution(* com.arnab.spring11_springaop.service.JobService.getJob(..)) && args(postId)")
    public Object validate(ProceedingJoinPoint jp,int postId) throws Throwable {
        if(postId<0){
            LOGGER.info("Post Id is negative. Fixing it....");
            postId=-postId;
        }

        Object obj=jp.proceed(new Object[]{postId});
        LOGGER.info("Post Id Fixed!!");
        return obj;
    }
}