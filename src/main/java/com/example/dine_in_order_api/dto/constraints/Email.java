package com.example.dine_in_order_api.dto.constraints;

import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotEmpty(message = "can not be null or blank !!")
@NotBlank(message = "can not be blank !!")
@jakarta.validation.constraints.Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail.com", message = "Email must be a valid Gmail address")
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email{
    String message()default "Email must be a valid Gmail address";
    Class<?>[] Groups() default {} ;
    Class<?extends Payload>[] payload() default {};
}

