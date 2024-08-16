package com.example.ch02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class SecondCommandLineRunner implements CommandLineRunner {
  @Override
  public void run(String... args) throws Exception {
    System.out.println("첫번째 CommandLineRunner 구현체~!");
  }
}
