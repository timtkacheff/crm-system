package ru.tkacheff.crm.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {
        return number != null && number.matches("^(?:\\+?\\d{3}[ -]?\\d{3}[ -]?\\d{5}|\\d{3})$");
    }
}
