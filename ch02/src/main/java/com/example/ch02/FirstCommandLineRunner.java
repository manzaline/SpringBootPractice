package com.example.ch02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class FirstCommandLineRunner implements CommandLineRunner {
  @Override
  public void run(String... args) throws Exception {
    for (String arg : args){
      System.out.println(arg);
    }
  }
}
