package com.example.dine_in_order_api.dto.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotEmpty(message = "can not be null or blank !!")
@NotBlank(message = "can not be blank !!")
@Pattern(regexp = "^[7-9]\\d{9}$", message = "Invalid Phone Number")
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface PhoneNo{
    String message()default "Invalid Phone Number";
    Class<?>[] Groups() default {} ;
    Class<?extends Payload>[] payload() default {};
}
