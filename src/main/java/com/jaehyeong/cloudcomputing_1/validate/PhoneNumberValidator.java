package com.jaehyeong.cloudcomputing_1.validate;

import com.jaehyeong.cloudcomputing_1.validate.anotation.ValidPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private static final String NUMBER_PATTERN_DASH = "^010-\\d{4}-\\d{4}$";
    private static final String NUMBER_PATTERN_WITHOUT_DASH = "^010//d{8}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if (value == null){
            return false;
        }
        return value.matches(NUMBER_PATTERN_DASH) || value.matches(NUMBER_PATTERN_WITHOUT_DASH);
    }
}
