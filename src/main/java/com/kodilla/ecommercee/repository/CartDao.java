package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartDao extends CrudRepository<Cart,Long> {
}
