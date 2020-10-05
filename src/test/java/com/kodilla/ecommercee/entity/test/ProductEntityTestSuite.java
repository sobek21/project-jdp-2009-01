package com.kodilla.ecommercee.entity.test;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {
    @Autowired
    UserDao userDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    CartDao cartDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    GroupDao groupDao;

    @Test
    public void testProductDaoSave() {
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Cart> carts = new ArrayList<>();

        Product buty = new Product(1L, "buty",
                150.0, 1);
        Order order = new Order();
        Cart cart = new Cart();
        User piotr = new User();
        Group obuwie = new Group();

        piotr.setUserId(3L);
        piotr.setUsername("Piotr");
        piotr.setPassword("jsmith123");

        order.setOrderId(2L);

        cart.setCartId(4L);


        obuwie.setProducts(products);
        buty.setGroup(obuwie);


//        userDao.save(piotr);
//        cartDao.save(cart);
//        groupDao.save(obuwie);
        productDao.save(buty);
//        orderDao.save(order);

        long id = buty.getProductId();
//
        assertEquals(1, id);
    }
}
