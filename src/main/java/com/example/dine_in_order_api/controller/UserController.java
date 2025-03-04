package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.service.UserService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import com.example.dine_in_order_api.utility.ValidationErrorsStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Tag(name ="User controller", description = "Collection of API Endpoints for User Management")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/registration")
    @Operation(description = """
            The API Endpoint is used to register user.
            The endpoints requires the user to select one of the specified role along with the other details
            """,
            responses = {
                    @ApiResponse(responseCode = "201",description = "User Created"),
                    @ApiResponse(responseCode = "401", description = "Invalid Input", content = {
                            @Content(schema = @Schema(implementation = ValidationErrorsStructure.class))
                    })
            }
    )
    public ResponseEntity<ResponseStructure<UserResponce>> registration(@Valid @RequestBody  RegistrationRequest registrationRequest) {
        System.out.println("user name :"+registrationRequest.getUsername());
        UserResponce registration = userService.registration(registrationRequest);
        return ResponseBuilder.success(registration,HttpStatus.CREATED,"Data Stored !!");
    }
    //find by id
    @GetMapping("/fetch")
    public ResponseEntity<ResponseStructure<UserResponce>> findById(@RequestParam Long id) {
        UserResponce user = userService.findById(id);
        return ResponseBuilder.success(user,HttpStatus.FOUND,"Data Fetched !!");
    }

    //update by id
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<UserResponce>> updateById(@RequestBody @Valid UserRequest user, @RequestParam Long userId){
        UserResponce userRes = userService.updateById(user,userId);
        return ResponseBuilder.success(userRes,HttpStatus.OK,"Data Updated");
    }
}
