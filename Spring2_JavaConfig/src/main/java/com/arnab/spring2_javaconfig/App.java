package com.arnab.spring2_javaconfig;


import com.arnab.spring2_javaconfig.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context1=new AnnotationConfigApplicationContext(AppConfig.class);
        Alien al=context1.getBean(Alien.class);
        al.code();

//        creating the container
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt=context.getBean(Desktop.class);
//        dt.compile();

//        Desktop dt1=context.getBean(Desktop.class);
//        dt1.compile();
    }
}
