package com.abc.main;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.service.AdviceManager;

@SuppressWarnings("resource")
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdviceManager manager = context.getBean(AdviceManager.class);
        //manager.beforeAdvice();
        //manager.afterReturning();
        //manager.afterThrowing();
        //manager.afterAdvice();
        //String result = manager.aroundAdvice("aa", 1, "bb");
        //System.out.println("返回值：" + result);
        //String result = manager.manyAdvices("aa", "bb");
        //System.out.println("Test方法中调用切点方法的返回值：" + result);
        manager.accessAdvice(new Date(), "test");
    }
}
