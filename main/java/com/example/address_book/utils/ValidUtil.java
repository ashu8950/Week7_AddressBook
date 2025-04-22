package com.example.address_book.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ValidUtil {

    // Utility method to handle validation errors
    public static String getValidationErrors(BindingResult result) {
        StringBuilder errors = new StringBuilder();
        for (FieldError fieldError : result.getFieldErrors()) {
            errors.append(fieldError.getField())
                  .append(": ")
                  .append(fieldError.getDefaultMessage())
                  .append("\n");
        }
        return errors.toString();
    }
}
