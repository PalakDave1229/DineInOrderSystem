package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.request.RestaurantRequest;
import com.example.dine_in_order_api.dto.responce.RestaurestResponse;
import com.example.dine_in_order_api.service.RestaurentService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import com.example.dine_in_order_api.utility.ValidationErrorsStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
@Tag(name ="Restaurant controller", description = "Collection of API Endpoints for Restaurant Management")
public class RestaurantController {

    private RestaurentService restaurentService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/restaurant")
    @Operation(description = """
            The API Endpoint is used to Add Restaurant details.
            The endpoints requires the  Restaurant to select one of the specified role along with the other details.            
            """,
            responses = {@ApiResponse(responseCode = "200" ,description = "Restaurant Added"),
                         @ApiResponse(responseCode = "401" , description = "Invaild Input" ,
                    content = {@Content(schema = @Schema(implementation = ValidationErrorsStructure.class))})
            }
    )
    public ResponseEntity<ResponseStructure<RestaurestResponse>>
    createRestaurant(@Valid @RequestBody RestaurantRequest restaurantRequest){

        RestaurestResponse restaurestResponse =
                restaurentService.createRestaurant(restaurantRequest);

        return ResponseBuilder.created(
                restaurestResponse, "Restaurant Added successfully !! ");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/restaurant")
    @Operation(description = """
            The API Endpoint is used to update Restaurant details.
            The endpoints requires the Restaurant to select one of the specified role along with the other details.            
            """,
            responses = {@ApiResponse(responseCode = "200" ,description = "Restaurant Updated"),
                    @ApiResponse(responseCode = "401" , description = "Invaild Input" ,
                            content = {@Content(schema = @Schema(implementation = ValidationErrorsStructure.class))})
            }
    )
    public ResponseEntity<ResponseStructure<RestaurestResponse>> updateRestaurant(
            @PathVariable long restaurantId,@Valid @RequestBody RestaurantRequest restaurantRequest){

        RestaurestResponse restaurestResponse =
                restaurentService.updateRestaurant(restaurantRequest,restaurantId);

        return ResponseBuilder.created(
                restaurestResponse, "Restaurant Updated !!");
    }
}
