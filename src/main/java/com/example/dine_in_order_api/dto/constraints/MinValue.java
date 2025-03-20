package com.example.dine_in_order_api.dto.constraints;

import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Pattern(regexp = "^[a-zA-Z0-9]{3,}$")
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinValue {
    String message()default "value should have minimum 3 character or digit";
    Class<?>[] Groups() default {} ;
    Class<?extends Payload>[] payload() default {};
}
