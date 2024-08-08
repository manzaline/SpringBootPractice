package com.example.springbootpractice;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartingEventListener2 implements ApplicationListener<ApplicationStartingEvent>{
  
  @Override
  public void onApplicationEvent(ApplicationStartingEvent event) {
    System.out.println("이벤트리스너2에서 생성된 두번째 이벤트: "+event.getTimestamp());
  }
}
