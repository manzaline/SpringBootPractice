package com.example.springbootpractice;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

import org.slf4j.Logger;

import java.util.Date;
import java.util.Properties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringBootPracticeApplication {      

  private static final Logger log =
 LoggerFactory.getLogger(SpringBootPracticeApplication.class);

  public static void main(String[] args) {

    ConfigurableApplicationContext applicationContext = 
        SpringApplication.run(SpringBootPracticeApplication.class, args);

    AppService appService = applicationContext.getBean(AppService.class);
    log.info(appService.getAppProperties().toString());

    // Properties properties = new Properties();
    // properties.setProperty("spring.config.on-not-found", "ignore");

    // SpringApplication springApplication = new SpringApplication(SpringBootPracticeApplication.class);
    // springApplication.addListeners(new ApplicationStartingEventListener(), new ApplicationStartingEventListener2());
    // springApplication.setWebApplicationType(WebApplicationType.NONE);
    // springApplication.setDefaultProperties(properties);
    // springApplication.run(args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void applicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
    // System.out.println("스프링이 준비되면 표시: " + new Date(applicationReadyEvent.getTimestamp()));
  }
}
