package com.example.ch02.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CreateUser implements CommandLineRunner {

  private static Logger log = LoggerFactory.getLogger(CreateUser.class);

  @Override
  public void run(String... args) throws Exception {

    User user1 = new User("rhkr01","123456");

    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<User>> violations = validator.validate(user1);

    log.error("패스워드 규칙에 맞지 않습니다.");
    violations.forEach(violation -> log.error("유효성 검사에 통과하지 못했습니다 [{}]", violation.getMessageTemplate()));

    User user2 = new User("rhkr02","Sbip01$4UDfg");
    violations = validator.validate(user2);
    if(violations.isEmpty()) log.info("유효성 검사에 통과하였습니다.");
    violations.forEach(violation -> log.error("유효성 검사에 통과하였습니다. [{}]", violation.getMessageTemplate()));

    User user3 = new User("rhkr03","Sbip01$4UDfgggg");
    violations = validator.validate(user3);
    log.error("패스스워드에 최대동일한 문자3개이상이 들어가면 안됩니다.");
    violations.forEach(violation -> log.error("유효성 검사에 통과하지 못했습니다 [{}]", violation.getMessageTemplate()));

    User user4 = new User("rhkr04","Sbip014UDfgggg");
    violations = validator.validate(user4);
    log.error("패스워드에 특수문자가 포함되어야합니다.");
    violations.forEach(violation -> log.error("유효성 검사에 통과하지 못했습니다 [{}]", violation.getMessageTemplate()));
  }
}
