package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.request.TableRequest;
import com.example.dine_in_order_api.dto.responce.TableResponce;
import com.example.dine_in_order_api.exception.RestaurantNotFoundException;
import com.example.dine_in_order_api.mapper.TableMapper;
import com.example.dine_in_order_api.model.RestaurantTable;
import com.example.dine_in_order_api.model.Restaurent;
import com.example.dine_in_order_api.repository.RestaurentRepository;
import com.example.dine_in_order_api.repository.TableRepository;
import com.example.dine_in_order_api.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TableServiceImpl implements TableService {

    private final TableRepository tableRepository;
    private final TableMapper tableMapper;
    private final RestaurentRepository restaurentRepository;

    @Override
    public TableResponce createTable(long restaurantId, TableRequest tableRequest) {
        RestaurantTable restaurantTable = tableMapper.mapToRestaurantTable(tableRequest);

        Restaurent restaurent = restaurentRepository.findById(restaurantId)
                .orElseThrow( () -> new RestaurantNotFoundException("Restaurant not found !!"));

        restaurantTable.setRestaurent(restaurent);
        tableRepository.save(restaurantTable);
        return tableMapper.mapToTableResponce(restaurantTable);
    }
}
