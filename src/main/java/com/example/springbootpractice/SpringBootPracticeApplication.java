package com.example.springbootpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPracticeApplication {

  public static void main(String[] args) {
    SpringApplication springApplication = 
        new SpringApplication(SpringBootPracticeApplication.class);

    springApplication.setWebApplicationType(WebApplicationType.REACTIVE);

    springApplication.run(args);
  }

}
