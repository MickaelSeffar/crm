package com.seffar.crm;

import com.seffar.crm.business.OrderService;
import com.seffar.crm.dao.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class OrderServiceTests {
    @Autowired
    OrderService orderService;


    @Test
    public void testFindAll(){
        System.out.println(orderService.getOrders());
    }
    @Test
    public void testFindById(){
        Optional<Order> optionalOrder = orderService.getOrderById(1);
        if (optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            System.out.println(order);
        }
    }
}
