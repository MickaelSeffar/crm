package com.seffar.crm.api.mapper;

import com.seffar.crm.api.dtos.OrderDTO;
import com.seffar.crm.dao.entity.Order;

public class OrderMapper {

    public static OrderDTO convertToDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setType_presta(order.getType_presta());
        orderDTO.setDesignation(order.getDesignation());
        orderDTO.setClient(order.getClient());
        orderDTO.setNb_days(order.getNb_days());
        orderDTO.setUnit_price(order.getUnit_price());
        orderDTO.setTotal_exclude_taxe(order.getTotal_exclude_taxe());
        orderDTO.setTotal_with_taxe(order.getTotal_with_taxe());
//        orderDTO.setState(order.getState());
        return orderDTO;
    }

    public static Order convertToEntity(OrderDTO orderDTO){
        Order order = new Order();
        order.setType_presta(orderDTO.getType_presta());
        order.setDesignation(orderDTO.getDesignation());
        order.setClient(orderDTO.getClient());
        order.setNb_days(orderDTO.getNb_days());
        order.setUnit_price(orderDTO.getUnit_price());
        order.setTotal_exclude_taxe(orderDTO.getTotal_exclude_taxe());
        order.setTotal_with_taxe(orderDTO.getTotal_with_taxe());
//        order.setState(orderDTO.getState());
        return order;
    }
}

