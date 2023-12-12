package com.springboot.restproject.config.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelephoneValidator implements ConstraintValidator<Telephone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null){
            return false;
        }
        return value.matches("01(?:0|1|[6-9])[.-]?(\\d{3}\\d{4})[.-]?(\\d{4})$");
    }
}
