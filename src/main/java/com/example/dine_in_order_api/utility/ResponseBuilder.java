package com.example.dine_in_order_api.utility;

import com.example.dine_in_order_api.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.function.ServerRequest;

public class ResponseBuilder {
    public static <T> ResponseEntity<ResponseStructure<T>> success(T data, HttpStatus httpStatus, String message) {
        ResponseStructure<T> res = ResponseStructure.<T>builder()
                .message(message)
                .httpStatus(httpStatus.value())
                .data(data)
                .build();
        return ResponseEntity.status(httpStatus).body(res);
    }
    public static <T> ResponseEntity<ResponseStructure<T>> success(T data, HttpStatus httpStatus, String message, HttpHeaders headers) {
        ResponseStructure<T> res =  ResponseStructure.<T>builder()
                .message(message)
                .httpStatus(httpStatus.value())
                .data(data)
                .build();
        return ResponseEntity.status(httpStatus)
                .headers(headers)
                .body(res);

    }
    public static ResponseEntity<SimpleErrorStructure> simpleError(String message, HttpStatus httpStatus) {
        SimpleErrorStructure simpleErrorStructure = SimpleErrorStructure.builder()
                .code(httpStatus.value())
                .message(message)
                .type(httpStatus.name())
                .build();
        return ResponseEntity
                .status(httpStatus)
                .body(simpleErrorStructure);
    }

}
