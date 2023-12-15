package com.seffar.crm.business;

import com.seffar.crm.dao.entity.Order;
import com.seffar.crm.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrders(){
       return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Integer id){
        return orderRepository.findById(id);
    }

    public void addOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }

    // dans la table SQL alors Hibernate va faire un INSERT
    public Order update(Order order){
        orderRepository.save(order);
        return order;
    }
}
