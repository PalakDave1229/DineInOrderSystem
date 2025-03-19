package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.responce.BillResponse;
import com.example.dine_in_order_api.enums.OrderStatus;
import com.example.dine_in_order_api.enums.TableStatus;
import com.example.dine_in_order_api.exception.NoBillFoundException;
import com.example.dine_in_order_api.mapper.BillMapper;
import com.example.dine_in_order_api.model.Bill;
import com.example.dine_in_order_api.model.Order;
import com.example.dine_in_order_api.model.RestaurantTable;
import com.example.dine_in_order_api.model.Restaurent;
import com.example.dine_in_order_api.repository.*;
import com.example.dine_in_order_api.service.BillService;
import com.example.dine_in_order_api.utility.PDFGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final TableRepository tableRepository;
    private final OrderRepository orderRepository;
    private final BillMapper billMapper;
    private final PDFGenerator billGenerator;
    private final RestaurentRepository restaurentRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public BillResponse createBill(long tableId) {

        RestaurantTable restaurantTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new NoSuchElementException("Table not found !!"));

        List<Order> orderList = orderRepository.findByRestaurantTable(restaurantTable, OrderStatus.PAID);
        double totalAmount = orderList.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
        Bill bill = null;
        if (!orderList.isEmpty()) {
            bill = new Bill();
            bill.setOrders(orderList);
            bill.setTotalPayableAmount(totalAmount);
            billRepository.save(bill);
        } else {
            throw new NoSuchElementException(" No CartItem Selected !! ");
        }
        orderList.forEach(order -> order.setOrderStatus(OrderStatus.PAID));
        restaurantTable.setStatus(TableStatus.AVAILABLE);
        tableRepository.save(restaurantTable);
        orderRepository.saveAll(orderList);

        return billMapper.mapToBillResponse(bill);
    }

    @Override
    public BillResponse findById(long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new NoBillFoundException("No bill found with " + billId + " id"));
        return billMapper.mapToBillResponse(bill);
    }

    @Override
    public byte[] pdfGenerator(long billId) throws IOException {

        BillResponse response = this.findById(billId);

        long foodId = response.getOrders().getFirst().getCartItems().getFirst().getFoodItem().getId();

        Restaurent restaurantName = restaurentRepository.findNameByFoodItems_Id(foodId);

        long orderId = response.getOrders().getFirst().getOrderId();

        Order order = orderRepository.findRestaurantTableByOrderId(orderId);

        System.out.println(response);

        Map<String, Object> bill = Map.of("restaurantName", restaurantName.getName(),
                "tableNo",order.getRestaurantTable().getTableNumber(),
                "bill", response);

        return billGenerator.generatePdf("billUI", bill);
    }
}

