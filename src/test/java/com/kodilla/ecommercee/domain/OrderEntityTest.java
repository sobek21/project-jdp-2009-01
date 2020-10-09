package com.kodilla.ecommercee.domain;



import com.kodilla.ecommercee.repository.OrderDao;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.repository.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTest {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void testOrderDaoSave() {

        //Given
        Order order = new Order();
        //When
        orderDao.save(order);
        //Then
        Long id = order.getOrderId();
        Optional<Order> orderTest = orderDao.findById(id);
        Assert.assertTrue(orderTest.isPresent());
        //cleanUp
        orderDao.deleteById(id);

    }

    @Test
    public void findAllOrders() {
        //Given
        User user = new User("Mati","Test",1);
        User user2 = new User("Mati1","Test1",2);

        List<Product> products = new ArrayList<>();
        Order order = new Order();
        Order order2 = new Order();
        order.setUser(user);
        order2.setUser(user2);
        order.setProducts(products);
        order2.setProducts(products);
        //When
        orderDao.save(order);
        orderDao.save(order2);
        List<Order> orders = (List<Order>) orderDao.findAll();
        //Then
        Assert.assertEquals(2, orders.size());
        //Cleanup
        orderDao.deleteAll();
        userDao.deleteAll();
    }
    @Test
    public void findOrder() {
        //Given
        User user = new User("Test", "Haslo", 1);
        User user2 = new User("Test2", "Haslo2", 2);
        List<Product> products = new ArrayList<>();
        Order order = new Order(user, products);
        Order order2 = new Order(user2, products);
        //When
        orderDao.save(order);
        orderDao.save(order2);

        long id = order2.getOrderId();
        Optional<Order> orders =  orderDao.findById(id);
        //Then
        Assert.assertTrue(orders.isPresent());
        //Cleanup
        orderDao.deleteAll();
        userDao.deleteAll();
    }
    @Test
    public void deleteById() {
        //Given
        User user = new User("Test", "Haslo", 1);
        User user2 = new User("Test2", "Haslo2", 2);
        List<Product> products = new ArrayList<>();
        Order order = new Order(user, products);
        Order order2 = new Order(user2, products);
        //When
        orderDao.save(order);
        orderDao.save(order2);

        long id = order2.getOrderId();
        orderDao.deleteById(id);
        List<Order> orders = (List<Order>) orderDao.findAll();
        //Then
        Assert.assertEquals(1,orders.size());
        //Cleanup
        orderDao.deleteAll();
        userDao.deleteAll();
    }
    }


