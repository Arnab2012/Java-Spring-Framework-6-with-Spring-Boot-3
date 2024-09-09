package com.arnab;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
//        creating Spring container
        ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
        Alien al= context.getBean(Alien.class);
//        al.age=21;
        System.out.println(al.getAge());
        al.code();
        Desktop1 des=(Desktop1) context.getBean(Desktop1.class);

    }
}
