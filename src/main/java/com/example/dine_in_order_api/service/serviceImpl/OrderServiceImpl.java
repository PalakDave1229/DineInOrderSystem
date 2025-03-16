package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.responce.OrderResponse;
import com.example.dine_in_order_api.enums.OrderStatus;
import com.example.dine_in_order_api.enums.TableStatus;
import com.example.dine_in_order_api.mapper.OrderMapper;
import com.example.dine_in_order_api.model.CartItem;
import com.example.dine_in_order_api.model.Order;
import com.example.dine_in_order_api.model.RestaurantTable;
import com.example.dine_in_order_api.repository.CartItemRepository;
import com.example.dine_in_order_api.repository.OrderRepository;
import com.example.dine_in_order_api.repository.TableRepository;
import com.example.dine_in_order_api.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final TableRepository tableRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderMapper orderMapper;


    @Override
    @Transactional
    public OrderResponse createOrder(long tableId) {
        RestaurantTable restaurantTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new NoSuchElementException("Table not found !!"));

        List<CartItem> cartItemList = cartItemRepository.findByRestaurantTable(restaurantTable);

        Order order = null ;

        if(!cartItemList.isEmpty()){
            order = new Order();
            order.setOrderStatus(OrderStatus.CONFIRMED);
            order.setCartItems(cartItemList);
            order.setRestaurantTable(restaurantTable);
            order.setTotalAmount(
                    cartItemList.stream()
                    .mapToDouble(CartItem::getTotalPrice)
                    .sum());
            orderRepository.save(order);
        }
        else{
            throw new NoSuchElementException(" No CartItem Selected !! ");
        }

        restaurantTable.setStatus(TableStatus.OCCUPIED);
        tableRepository.save(restaurantTable);

        cartItemList.forEach(item -> item.setOrdered(true));
        cartItemRepository.saveAll(cartItemList);

        return orderMapper.mapToOrderResponse(order);
    }
}
