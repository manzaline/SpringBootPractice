package com.example.ch01;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent>{

  @Override
  public void onApplicationEvent(ApplicationStartingEvent event) {
    System.out.println("ApplicationListener를 구현한 클래스의 출력: "+event.getTimestamp()); 
  }
}