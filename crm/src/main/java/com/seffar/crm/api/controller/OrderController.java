package com.seffar.crm.api.controller;

import com.seffar.crm.api.dtos.OrderDTO;
import com.seffar.crm.api.mapper.OrderMapper;
import com.seffar.crm.business.OrderService;
import com.seffar.crm.dao.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("orders")
    public List<OrderDTO> getAll() {
        List<Order> orders = orderService.getOrders();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order : orders)
            orderDTOS.add(OrderMapper.convertToDTO(order));
        return orderDTOS;
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<OrderDTO> getOne(@PathVariable("id") Integer id) {
        Optional<Order> optionalOrder = orderService.getOrderById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            OrderDTO orderDTO = OrderMapper.convertToDTO(order);
            return ResponseEntity.ok(orderDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("orders")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addOrder(@RequestBody OrderDTO orderDTO) {
        Order order = OrderMapper.convertToEntity(orderDTO);
        orderService.addOrder(order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id") Integer id) {
        Optional<Order> optionalOrder = orderService.getOrderById(id);
        if (optionalOrder.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            orderService.deleteOrder(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("orders/{id}")
    public ResponseEntity<Order> putOrder(@PathVariable Integer id, @RequestBody Order order) {
        Optional<Order> existingOrder = orderService.getOrderById(id);
        return existingOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
