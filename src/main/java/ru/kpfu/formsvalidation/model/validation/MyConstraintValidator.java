package ru.kpfu.formsvalidation.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.contains("kek");
    }

    @Override
    public void initialize(MyConstraint constraintAnnotation) {

    }
}
