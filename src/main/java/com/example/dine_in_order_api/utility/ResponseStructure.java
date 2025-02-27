package com.example.dine_in_order_api.utility;

import com.example.dine_in_order_api.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {
    private int httpStatus;
    private String message;
    private T data;

    public static <T> ResponseStructure<T> create(HttpStatus httpStatus, String message,T data) {
        ResponseStructure<T> responce = new ResponseStructure<>();
        responce.httpStatus = httpStatus.value();
        responce.message = message;
        responce.data = data;
        return responce;
    }
}
