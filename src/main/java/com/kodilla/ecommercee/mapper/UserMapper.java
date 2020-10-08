package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                orderMapper.orderDtoListToOrder(userDto.getOrdersDto()),
                userDto.isEnable()
        );
    }

    public UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                cartMapper.cartToCartDto(user.getCart()),
                orderMapper.orderListToOrderTo(user.getOrders()),
                user.isEnable()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> productList) {
        return productList.stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }
}
