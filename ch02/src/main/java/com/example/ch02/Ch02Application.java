package com.example.ch02;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Ch02Application {

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

    ConfigurableApplicationContext applicationContext = 
        SpringApplication.run(Ch02Application.class, args);

    AppService appService = 
        applicationContext.getBean(AppService.class);
    log.info(appService.getAppProperties().toString());
	}

}
