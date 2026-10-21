package org.example.notificationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService{

    @Override
    public void sendMsg(String msg) {
        System.out.println("EmailService:" + msg);
    }
}
