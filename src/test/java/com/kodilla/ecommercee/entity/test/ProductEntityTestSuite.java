//package com.kodilla.ecommercee.entity.test;
//
//import com.kodilla.ecommercee.domain.*;
//import com.kodilla.ecommercee.repository.CartDao;
//import com.kodilla.ecommercee.repository.GroupDao;
//import com.kodilla.ecommercee.repository.OrderDao;
//import com.kodilla.ecommercee.repository.ProductRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProductEntityTestSuite {
//    @Autowired
//    ProductRepository productDao;
//
//    @Autowired
//    CartDao cartDao;
//
//    @Autowired
//    GroupDao groupDao;
//
//    @Autowired
//    OrderDao orderDao;
//
//    @Test
//    public void testProductDaoSave() {
//
//        Product buty = new Product(1L, "buty",
//                150.0, 1);
//        User piotr = new User(1L, 59403L, "Piotr", "jsmith123");
//        Order order = new Order();
//        Group group = new Group(1L, "obuwie");
//        Cart cart = new Cart();
//
//        List<Product> products = new ArrayList<>();
//        List<Order> orders = new ArrayList<>();
//        List<Cart> carts = new ArrayList<>();
//
//        products.add(buty);
//        orders.add(order);
//        carts.add(cart);
//
//        order.setUser(piotr);
//        order.setProducts(products);
//        order.setOrderId(1L);
//
//        group.setProducts(products);
//
//        cart.setProducts(products);
//        cart.setUser(piotr);
//        cart.setCartId(cart.getCartId());
//        piotr.setCart(cart);
//
//        buty.setOrders(orders);
//        buty.setGroup(group);
//        buty.setCarts(carts);
//        productDao.save(buty);
//        cartDao.save(cart);
//        groupDao.save(group);
//        orderDao.save(order);
//
//
//        long butyProductId = buty.getProductId();
//
//        assertEquals(1, butyProductId);
//
//    }
//}
