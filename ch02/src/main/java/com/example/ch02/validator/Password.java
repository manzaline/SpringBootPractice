package com.example.ch02.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD}) // @Password 애노테이션을 적용 가능한 대상 타입. 필드와 메서드에 적용 가능.
@Retention(RetentionPolicy.RUNTIME) // @Password 애너테이션이 언제까지 효력을 유지하고 살아남는지 지정. 현재는 JVM RUNTIME까지 살아남아 효력을 유지한다.
@Constraint(validatedBy = PasswordRuleValidator.class) // @Password 애너테이션이 PasswordRuleValidator.class를 포함한다는 뜻
public @interface Password {

  String message() default "패스워드는 최소 8자리 이상, 대문자 하나를 포함, 소문자 하나를 포함, 숫자를 하나포함, 특수문자 하나를 포함한다";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
