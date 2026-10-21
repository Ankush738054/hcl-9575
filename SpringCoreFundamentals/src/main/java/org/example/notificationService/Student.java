package org.example.notificationService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Student {
    private NotificationService notificationService;
    @Autowired
    public Student(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void notifyStudent(){
        notificationService.sendMsg("Your Assessment is Scheduled");
    }

    @PostConstruct
    public void init(){
        System.out.println("Object created");
    }
    @PreDestroy
    public  void destroy(){
        System.out.println("Object destroyed");
    }
}
