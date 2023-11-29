package com.seffar.crm;


import com.seffar.crm.dao.OrderState;
import com.seffar.crm.dao.entity.Client;
import com.seffar.crm.dao.entity.Order;
import com.seffar.crm.dao.repository.ClientRepository;
import com.seffar.crm.dao.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class OrderRepositoryTests {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;


    @Test
    void getAll() {
        orderRepository.findAll();
    }

    @Test
    void testSaveOrder() {
        Optional<Client> optionalClient = clientRepository.findById(1);
        Client client = optionalClient.get();
        Order order = new Order();
        order.setType_presta("Type de prestation");
        order.setDesignation("Designation de la commande");
        order.setClient(client);
        order.setNb_days(5);
        order.setUnit_price(10.40);
        order.setState(OrderState.CONFIRMED); // État de la commande
        orderRepository.save(order);

    }
}