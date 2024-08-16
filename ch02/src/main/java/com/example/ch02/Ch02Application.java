package com.example.ch02;

import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Ch02Application implements CommandLineRunner {

  private static final Logger log =
          LoggerFactory.getLogger(Ch02Application.class);

  public static void main(String[] args) {

    // Properties properties = new Properties();
    // properties.setProperty("spring.config.on-not-found", "ignore");
    // SpringApplication springApplication = 
    //     new SpringApplication(Ch02Application.class);
    // springApplication.setDefaultProperties(properties);
    // springApplication.run(args);

    // ConfigurableApplicationContext applicationContext = 
    //     SpringApplication.run(Ch02Application.class, args);

    // DBConfiguration dbConfiguration = 
    //     applicationContext.getBean(DBConfiguration.class);
    // log.info(dbConfiguration.toString());

    // ConfigurableApplicationContext applicationContext = 
    //     SpringApplication.run(Ch02Application.class, args);        
    // AppService appService = 
    //     applicationContext.getBean(AppService.class);
    // log.info(appService.getAppProperties().toString());

    SpringApplication.run(Ch02Application.class, args);

  }

  @Override
  public void run(String[] args) {
    Course course = new Course();
    String[] rate = {};
    course.setName(" ");
    course.setCategory(" ");
    course.setId(88);
    course.setRating(rate);


    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Course>> violations = validator.validate(course);

    violations.forEach(violation ->
              log.error("유효성검증에 통과하지 못했습니다 [{}]", violation.getMessageTemplate())
            );
  }

//    @Bean
//    public CommandLineRunner commandLineRunner() {
//        return args -> { // CommandLineRunner는 함수형 인터페이스구만!
//          System.out.println("CommandLineRunner 의 run매서드 실행~!");
//          System.out.println(("args: ")+ Arrays.toString(args));
//        };
//    }
}