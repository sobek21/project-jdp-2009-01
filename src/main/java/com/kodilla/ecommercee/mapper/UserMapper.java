package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    public User mapUserDtoToUser(UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getUsername(),
                userDto.getPassword(),
                cartMapper.cartDtoToCart(userDto.getCartDto()),
                orderMapper.mapToOrderDtoList(userDto.getOrdersDto())
        );
    }

    public UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                cartMapper.cartToCartDto(user.getCart()),
                orderMapper.mapToOrderDtoList(user.getOrders())
        );
    }
}
