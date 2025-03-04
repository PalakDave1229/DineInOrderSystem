package com.example.dine_in_order_api.utility;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class ValidationErrorsStructure extends  SimpleErrorStructure {

    private List<Errors> errors;

    public static Errors create(String message,Object rejectedValue,String field){
        Errors errors = new Errors();
        errors.message = message;
        errors.rejectedValue = rejectedValue;
        errors.field = field;
        return errors;
    }

    @Getter
    public static class Errors{
        private String message;
        private Object rejectedValue;
        private String field;
    }
}
