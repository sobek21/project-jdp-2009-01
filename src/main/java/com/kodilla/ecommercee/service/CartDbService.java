package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.exception.order.CartNotFoundException;
import com.kodilla.ecommercee.exception.product.ProductNotFoundException;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartDbService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    public Cart getCartById (final Long id) throws CartNotFoundException {
        return cartDao.findById(id).orElseThrow(()-> new CartNotFoundException(id));
    }
    public Cart createCart (Cart cart) {
        return cartDao.save(cart);
    }
    public Cart addProductToCart (final Long cartId, final Long productId) throws CartNotFoundException, ProductNotFoundException {
        Cart cartToAddProduct = cartDao.findById(cartId).orElseThrow(()-> new CartNotFoundException(cartId));
        cartToAddProduct.getProducts().add(productDao.findById(productId).orElseThrow(()-> new ProductNotFoundException()));
        return cartDao.save(cartToAddProduct);
    }
    public Cart deleteProductFromCart (final Long cartId, final Long productId) throws CartNotFoundException, ProductNotFoundException {
        Cart deleteProductFromCart = cartDao.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
        deleteProductFromCart.getProducts().remove(productDao.findById(productId).orElseThrow(() -> new ProductNotFoundException()));
        return cartDao.save(deleteProductFromCart);
    }
}
