package com.hackerrank.configstyles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hackerrank.configstyles.service.EmailNotificationService;
import com.hackerrank.configstyles.service.NotificationService;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Bean(name="emailNotificationService")
    public NotificationService emailNotificationService() {
    	return new EmailNotificationService("EMAIL_SERVICE");
    }
  
}