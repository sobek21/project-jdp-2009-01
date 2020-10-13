package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order();

    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto();

    }

    public List<Order> orderDtoListToOrder(List<OrderDto> orderDtoList) {
        return new ArrayList<>();
    }

    public List<OrderDto> orderListToOrderTo(List<Order> orderList) {
        return new ArrayList<>();
    }
}
