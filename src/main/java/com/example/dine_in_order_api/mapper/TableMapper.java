package com.example.dine_in_order_api.mapper;


import com.example.dine_in_order_api.dto.request.TableRequest;
import com.example.dine_in_order_api.dto.responce.TableResponce;
import com.example.dine_in_order_api.model.RestaurantTable;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TableMapper {

    RestaurantTable mapToRestaurantTable(TableRequest tableRequest);

    TableResponce mapToTableResponce(RestaurantTable restaurantTable);
}
