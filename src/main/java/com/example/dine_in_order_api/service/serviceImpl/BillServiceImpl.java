package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.responce.BillResponse;
import com.example.dine_in_order_api.enums.OrderStatus;
import com.example.dine_in_order_api.enums.TableStatus;
import com.example.dine_in_order_api.mapper.BillMapper;
import com.example.dine_in_order_api.model.Bill;
import com.example.dine_in_order_api.model.Order;
import com.example.dine_in_order_api.model.RestaurantTable;
import com.example.dine_in_order_api.repository.BillRepository;
import com.example.dine_in_order_api.repository.OrderRepository;
import com.example.dine_in_order_api.repository.TableRepository;
import com.example.dine_in_order_api.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;
    private final TableRepository tableRepository;
    private final OrderRepository orderRepository;
    private  final BillMapper billMapper;

    @Override
    public BillResponse createBill(long tableId) {

        RestaurantTable restaurantTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new NoSuchElementException("Table not found !!"));

        List<Order> orderList = orderRepository.findByRestaurantTable(restaurantTable,OrderStatus.PAID);
        double totalAmount = orderList.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
        Bill bill = null;
        if(!orderList.isEmpty()) {
            bill = new Bill();
            bill.setOrders(orderList);
            bill.setTotalPayableAmount(totalAmount);
            billRepository.save(bill);
        }
        else{
            throw new NoSuchElementException(" No CartItem Selected !! ");
        }

        orderList.forEach(order -> order.setOrderStatus(OrderStatus.PAID));
        restaurantTable.setStatus(TableStatus.AVAILABLE);
        tableRepository.save(restaurantTable);
        orderRepository.saveAll(orderList);

        return billMapper.mapToBillResponse(bill);
    }
}
