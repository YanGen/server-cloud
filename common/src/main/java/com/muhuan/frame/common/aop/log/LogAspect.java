package com.muhuan.frame.common.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.regex.Pattern;


@Slf4j
@Aspect
@Order(2)
@Component
public class LogAspect {

    private static final ThreadLocal<Long> timeTreadLocal = new ThreadLocal<>();


    //    @Pointcut("execution( * com.dou.controller..*.*(..))")
    @Pointcut("@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)")
    public void logPointcut() {

    }

    @Before("logPointcut()")
    public void methodBefore(JoinPoint joinPoint) {
        timeTreadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        log.info("---------------请求内容---------------");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature().getName());
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("---------------请求内容---------------");
    }


    @AfterReturning(returning = "o", pointcut = "logPointcut()")
    public void methodAfterReturning(Object o) {
        log.info("===============返回内容===============");
        if (o != null)
            log.info("返回的内容:" + o != null ?o.toString() : null);
        log.info("===============返回内容===============");
        long startTime = timeTreadLocal.get();
        double callTime = (System.currentTimeMillis() - startTime) / 1000.0;
        log.info("调用花费时间time = {}s", callTime);
    }


    @AfterThrowing(pointcut = "logPointcut()", throwing = "throwable")
    public void logThrowing(JoinPoint joinPoint, Throwable throwable) {
        log.info("***************抛出异常***************");

        log.info("请求类方法:" + joinPoint.getSignature().getName());
        log.info("异常内容:" + throwable.getMessage());
        StackTraceElement[] sarr = throwable.getStackTrace();
        for (StackTraceElement st : sarr) {
            if(isMatchString(st.getClassName())){
                log.info(st.toString());
            }
        }
        log.info("***************抛出异常***************");

        long startTime = timeTreadLocal.get();
        double callTime = (System.currentTimeMillis() - startTime) / 1000.0;
        log.info("调用花费时间time = {}s", callTime);

    }

    private boolean isMatchString(String s){
        return Pattern.matches("com.uniteddata.antzure.*", s);
    }

}