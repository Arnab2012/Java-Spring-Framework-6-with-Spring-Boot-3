package com.arnab.config;

import com.arnab.Alien;
import com.arnab.Computer;
import com.arnab.Desktop;
import com.arnab.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.arnab")
public class AppConfig {


//    creating Bean for Alien Class
//    @Bean
//    public Alien alien(Computer com){ // @Qualifier("laptop")
//        Alien obj=new Alien();
//        obj.setAge(25);
//        obj.setCom(com);
//        return obj;
//    }
////    creating Bean for Desktop Class
////    @Bean(name = "com2") by default name is method name but we can give name like this as well
//    @Bean
//    @Scope("prototype")
//    @Primary
//    public Desktop desktop(){
//        return new Desktop();
//    }
//
////    creating Bean for Laptop
//    @Bean
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
