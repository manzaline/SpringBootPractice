package com.example.ch01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.util.Date;

@SpringBootApplication
public class Ch01Application {      

  public static void main(String[] args) {
    
    SpringApplication springApplication = new SpringApplication(Ch01Application.class);
    springApplication.addListeners(new ApplicationStartingEventListener(), new ApplicationStartingEventListener2());
    springApplication.setWebApplicationType(WebApplicationType.NONE);
    springApplication.run(args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void applicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
    System.out.println("스프링이 준비되면 표시: " + new Date(applicationReadyEvent.getTimestamp()));
  }
  // @EventListener(ApplicationReadyEvent.class)
  // public void applicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
  //   // System.out.println("스프링이 준비되면 표시: " + new Date(applicationReadyEvent.getTimestamp()));
  // }
}
