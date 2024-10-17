package com.jaehyeong.cloudcomputing_1.validate.anotation;

import com.jaehyeong.cloudcomputing_1.validate.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {
    String message() default "유효하지 않은 번호 형식입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}