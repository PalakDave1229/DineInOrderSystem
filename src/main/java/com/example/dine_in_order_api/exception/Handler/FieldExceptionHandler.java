package com.example.dine_in_order_api.exception.Handler;

import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ValidationErrorsStructure;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class FieldExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object>  handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ValidationErrorsStructure.Errors> errorsList = new ArrayList<ValidationErrorsStructure.Errors>();
        List<ObjectError> fieldErrors = ex.getAllErrors(); //

        for(ObjectError er : fieldErrors){
            FieldError fe = (FieldError) er;
            errorsList.add(ValidationErrorsStructure.create(
                             er.getDefaultMessage()
                            ,fe.getRejectedValue()
                            ,fe.getField()));

        }
        return ResponseEntity.status(ex.getStatusCode())
                .body(ResponseBuilder.ValidationError(
                    HttpStatus.valueOf(ex.getStatusCode().value()),
                    ex.getMessage(),
                    errorsList));
    }
}
