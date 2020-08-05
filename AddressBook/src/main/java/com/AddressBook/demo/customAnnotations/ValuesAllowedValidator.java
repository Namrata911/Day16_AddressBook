package com.AddressBook.demo.customAnnotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ValuesAllowedValidator implements ConstraintValidator<ValuesAllowed, String> {

    private List<String> expectedValues;
    private String returnMessage;

    @Override
    public void initialize(ValuesAllowed requiredIfChecked) {
        expectedValues = Arrays.asList(requiredIfChecked.values());
        System.out.println("Testing");
        returnMessage = requiredIfChecked.message().concat(expectedValues.toString());
    }

    @Override
    public boolean isValid(String testValue, ConstraintValidatorContext context) {
        boolean valid = expectedValues.contains(testValue);
        System.out.println("TEstings!");
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(returnMessage)
                    .addConstraintViolation();
        }
        return valid;
    }
}