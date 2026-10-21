package org.example.fielddi;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp=ctx.getBean(Employee.class);
        String data=emp.displayAddress();
        System.out.println(data);
    }
}
