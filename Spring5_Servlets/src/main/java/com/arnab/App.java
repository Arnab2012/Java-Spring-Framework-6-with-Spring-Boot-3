package com.arnab;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;


public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );
//      creating object of Tomcat to start the server
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8081);

        Context context=tomcat.addContext("",null);
        Tomcat.addServlet(context,"HelloServlet",new HelloServlet());
        context.addServletMappingDecoded("/hello1","HelloServlet");

        tomcat.start(); // start the server;
        tomcat.getServer().await(); // to make sever await
    }
}
