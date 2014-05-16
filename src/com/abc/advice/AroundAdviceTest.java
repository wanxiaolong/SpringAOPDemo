package com.abc.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAdviceTest {
    @Around(value="execution(* com.abc.service.*.around*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("模拟执行目标方法前的增强处理：事务开始...");
        //修改目标方法的参数
        Object[] params = new Object[]{"param1", 2, "param3"};
        System.out.println("拦截的方法： " + point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("参数： " + Arrays.toString(point.getArgs()));
        //执行目标方法，并保存目标方法执行后的返回值
        Object returnValue = point.proceed(params);
        System.out.println("模拟执行目标方法后的增强处理：事务结束...");
        //返回修改后的返回值
        return "方法实际返回值：" + returnValue + "，这是返回值的后缀";
    }
}
