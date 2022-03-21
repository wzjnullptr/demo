package com.example.aspect;

import com.example.domain.WebLog;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

@Aspect
@Order(1)
@Component
public class WebLogAspect {

    @Pointcut("execution(public * com.example.controller.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List args = Arrays.asList(joinPoint.getArgs());
        System.out.println(className + "前置通知执行" + methodName + "执行参数为" + args.toString());
    }

    @AfterReturning(pointcut = "log()", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println("后置通知获取返回值结果" + ret);
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        WebLog webLog = new WebLog();
        long startTime = System.currentTimeMillis();
        Object result = null;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String userName = request.getRemoteUser();
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        String methodName = request.getMethod();
        String ip = request.getRemoteAddr();

        webLog.setStartTime(startTime);
        webLog.setUserName(userName);
        webLog.setUri(uri);
        webLog.setUrl(url);
        webLog.setMethod(methodName);
        webLog.setIp(ip);

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        webLog.setParameter(getParameter(method,joinPoint.getArgs()));
        try {
            result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            //指向常量池中的变量 new Integer指向堆
            Integer spendTime = (int) (endTime - startTime);
            webLog.setResult(result);
            webLog.setSpendTime(spendTime);
        } catch (Throwable e) {
            e.printStackTrace();
            long endTime = System.currentTimeMillis();
            Integer spendTime = (int) (endTime - startTime);
            webLog.setResult(result);
            webLog.setSpendTime(spendTime);
        }
        System.out.println(webLog.toString());
        return result;
    }

    private Object getParameter(Method method, Object[] args) {
        List argList = new ArrayList();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (null != requestBody) {
                argList.add(args[i]);
            }

            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (null != requestParam) {
                Map<String, Object> keyMap = new HashMap();
                String key = parameters[i].getName();
                //requestParam中value重命名key
                if (StringUtils.isNotEmpty(requestParam.value())) {
                    key = requestParam.name();
                }
                keyMap.put(key, args[i]);
                argList.add(keyMap);
            }
        }
        if (CollectionUtils.isNotEmpty(argList)) {
            return argList;
        } else {
            return null;
        }
    }
}
