package com.arnab.spring3_springboot;

import com.arnab.spring3_springboot.model.Laptop;
import com.arnab.spring3_springboot.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=SpringApplication.run(App.class,args);
//        Programmer coder=context.getBean(Programmer.class);
//        System.out.println(coder.getAge());
//        coder.code();

        LaptopService service=context.getBean(LaptopService.class);
        Laptop lap=context.getBean(Laptop.class);
        service.addLaptop();
    }
}
