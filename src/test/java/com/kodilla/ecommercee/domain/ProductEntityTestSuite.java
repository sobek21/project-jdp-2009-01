package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Product sandals = new Product();

        sandals.setProductName("sandals");
        sandals.setQuantity(1);
        sandals.setProductPrice(150.0);
        productDao.save(sandals);

        long id = sandals.getProductId();
        Optional<Product> readProduct = productDao.findById(id);

        assertTrue(readProduct.isPresent());
        try {
            productDao.deleteById(id);
        } catch (Exception e) {

        }
    }

    @Test
    public void testFindAllProducts() {

        Product sandals = new Product();
        Product banana = new Product();
        Product iceCream = new Product();

        sandals.setProductName("sandals");
        sandals.setQuantity(1);
        sandals.setProductPrice(150.0);

        banana.setProductName("banana");
        banana.setQuantity(4);
        banana.setProductPrice(4.0);

        iceCream.setProductName("iceCream");
        iceCream.setQuantity(2);
        iceCream.setProductPrice(1.5);

        productDao.save(sandals);
        long sandalsId = sandals.getProductId();
        productDao.save(banana);
        long bananaId = banana.getProductId();
        productDao.save(iceCream);
        long iceCreamId = iceCream.getProductId();

        List<Product> productsList = productDao.findAll();

        assertEquals(3, productsList.size());
        try {
            productDao.deleteById(sandalsId);
            productDao.deleteById(bananaId);
            productDao.deleteById(iceCreamId);
        } catch (Exception e){

        }
    }

    @Test
    public void testRelationsBetweenProductAndGroup() {
        List<Product> shoesList = new ArrayList<>();
        List<Product> foodsList = new ArrayList<>();

        Product sandals = new Product();
        Product banana = new Product();

        sandals.setProductName("sandals");
        sandals.setQuantity(1);
        sandals.setProductPrice(150.0);

        banana.setProductName("banana");
        banana.setQuantity(4);
        banana.setProductPrice(4.0);

        productDao.save(sandals);
        long sandalsId = sandals.getProductId();
        productDao.save(banana);
        long bananaId = banana.getProductId();

        Group shoes = new Group();
        Group foods = new Group();

        groupDao.save(foods);
        groupDao.save(shoes);

        shoesList.add(sandals);
        foodsList.add(banana);

        shoes.setProducts(shoesList);
        foods.setProducts(foodsList);

        banana.setGroup(foods);
        sandals.setGroup(shoes);


        assertEquals(1, shoesList.size());
        assertEquals(1, foodsList.size());
        assertEquals(sandals.getGroup().getId(), shoes.getProducts().get(0).getGroup().getId());
        assertEquals(banana.getGroup().getId(), foods.getProducts().get(0).getGroup().getId());

        try {
            productDao.deleteById(sandalsId);
            productDao.deleteById(bananaId);
            groupDao.deleteAll();
        } catch (Exception e) {

        }
    }

    @Test
    public void testRelationsBetweenProductAndCart() {
        Product sandals = new Product();
        Product banana = new Product();

        sandals.setProductName("sandals");
        sandals.setQuantity(1);
        sandals.setProductPrice(150.0);

        banana.setProductName("banana");
        banana.setQuantity(4);
        banana.setProductPrice(4.0);

        Cart cart = new Cart();
        Cart cart1 = new Cart();

        cart.getProducts().add(sandals);
        cart.getProducts().add(banana);
        cart1.getProducts().add(sandals);
        cart1.getProducts().add(banana);

        sandals.getCarts().add(cart);
        sandals.getCarts().add(cart1);
        banana.getCarts().add(cart);
        banana.getCarts().add(cart1);

        productDao.save(sandals);
        long sandalsId = sandals.getProductId();
        productDao.save(banana);
        long bananaId = banana.getProductId();

        cartDao.save(cart);
        cartDao.save(cart1);

        assertEquals(sandals.getCarts().get(0).getCartId(), cart.getCartId());
        assertEquals(sandals.getCarts().get(1).getCartId(), cart1.getCartId());
        assertEquals(banana.getCarts().get(0).getCartId(), cart.getCartId());
        assertEquals(banana.getCarts().get(1).getCartId(), cart1.getCartId());

        try {
            productDao.deleteById(sandalsId);
            productDao.deleteById(bananaId);
            cartDao.deleteAll();
        } catch (Exception e) {

        }
    }

    @Test
    public void testRelationsBetweenProductAndOrder() {
        List<Product> shoesList = new ArrayList<>();
        List<Product> foodsList = new ArrayList<>();

        Product sandals = new Product();
        Product banana = new Product();

        sandals.setProductName("sandals");
        sandals.setQuantity(1);
        sandals.setProductPrice(150.0);

        banana.setProductName("banana");
        banana.setQuantity(4);
        banana.setProductPrice(4.0);

        productDao.save(banana);
        long bananaId = banana.getProductId();
        productDao.save(sandals);
        long sandalsId = sandals.getProductId();

        shoesList.add(sandals);
        foodsList.add(banana);

        List<Order> orderList = new ArrayList<>();

        Order order = new Order();
        Order order1 = new Order();

        orderList.add(order);
        orderList.add(order1);

        orderDao.save(order);
        orderDao.save(order1);

        order.setProducts(shoesList);
        order.setProducts(foodsList);
        order1.setProducts(shoesList);
        order1.setProducts(foodsList);

        sandals.setOrders(orderList);
        banana.setOrders(orderList);


        assertEquals(order.getOrderId(), sandals.getOrders().get(0).getOrderId());
        assertEquals(order.getOrderId(), banana.getOrders().get(0).getOrderId());
        assertEquals(order1.getOrderId(), sandals.getOrders().get(1).getOrderId());
        assertEquals(order1.getOrderId(), banana.getOrders().get(1).getOrderId());
        try {
            productDao.deleteById(sandalsId);
            productDao.deleteById(bananaId);
            orderDao.deleteAll();
        } catch (Exception e) {

        }
    }

    @Test
    public void testDeleteProduct() {
        List<Product> shoesList = new ArrayList<>();
        List<Product> foodsList = new ArrayList<>();

        Product sandals = new Product();
        Product banana = new Product();

        sandals.setProductName("sandals");
        sandals.setQuantity(1);
        sandals.setProductPrice(150.0);

        banana.setProductName("banana");
        banana.setQuantity(4);
        banana.setProductPrice(4.0);

        productDao.save(banana);
        long bananaId = banana.getProductId();
        Optional<Product> readBanana = productDao.findById(bananaId);
        productDao.save(sandals);
        long sandalsId = sandals.getProductId();
        Optional<Product> readSandlas = productDao.findById(sandalsId);

        shoesList.add(sandals);
        foodsList.add(banana);



        List<Order> orderList = new ArrayList<>();

        Order order = new Order();
        Order order1 = new Order();

        orderList.add(order);
        orderList.add(order1);

        orderDao.save(order);
        long orderId = order.getOrderId();
        Optional<Order> readOrder = orderDao.findById(orderId);
        orderDao.save(order1);
        long order1Id = order1.getOrderId();
        Optional<Order> readOrder1 = orderDao.findById(order1Id);

        order.setProducts(shoesList);
        order.setProducts(foodsList);
        order1.setProducts(shoesList);
        order1.setProducts(foodsList);

        sandals.setOrders(orderList);
        banana.setOrders(orderList);

        assertEquals(order.getOrderId(), sandals.getOrders().get(0).getOrderId());
        assertEquals(order.getOrderId(), banana.getOrders().get(0).getOrderId());
        assertEquals(order1.getOrderId(), sandals.getOrders().get(1).getOrderId());
        assertEquals(order1.getOrderId(), banana.getOrders().get(1).getOrderId());



        Group shoes = new Group();
        Group foods = new Group();

        groupDao.save(foods);
        long foodsId = foods.getId();
        Optional<Group> readFoods = groupDao.findById(foodsId);
        groupDao.save(shoes);
        long shoesId = shoes.getId();
        Optional<Group> readShoes = groupDao.findById(shoesId);

        shoesList.add(sandals);
        foodsList.add(banana);

        shoes.setProducts(shoesList);
        foods.setProducts(foodsList);

        banana.setGroup(foods);
        sandals.setGroup(shoes);

        assertEquals(sandals.getGroup().getId(), shoes.getProducts().get(0).getGroup().getId());
        assertEquals(banana.getGroup().getId(), foods.getProducts().get(0).getGroup().getId());



        Cart cart = new Cart();
        Cart cart1 = new Cart();

        cartDao.save(cart);
        long cartId = cart.getCartId();
        Optional<Cart> readCart = cartDao.findById(cartId);
        cartDao.save(cart1);
        long cart1Id = cart.getCartId();
        Optional<Cart> readCart1 = cartDao.findById(cart1Id);

        cart.getProducts().add(sandals);
        cart.getProducts().add(banana);
        cart1.getProducts().add(sandals);
        cart1.getProducts().add(banana);

        sandals.getCarts().add(cart);
        sandals.getCarts().add(cart1);
        banana.getCarts().add(cart);
        banana.getCarts().add(cart1);

        assertEquals(sandals.getCarts().get(0).getCartId(), cart.getCartId());
        assertEquals(sandals.getCarts().get(1).getCartId(), cart1.getCartId());
        assertEquals(banana.getCarts().get(0).getCartId(), cart.getCartId());
        assertEquals(banana.getCarts().get(1).getCartId(), cart1.getCartId());

        productDao.deleteById(sandalsId);
        readSandlas = productDao.findById(sandalsId);

        assertFalse(readSandlas.isPresent());
        assertTrue(readOrder.isPresent());
        assertTrue(readOrder1.isPresent());
        assertTrue(readFoods.isPresent());
        assertTrue(readShoes.isPresent());
        assertTrue(readCart.isPresent());
        assertTrue(readCart1.isPresent());

        productDao.deleteById(bananaId);
        readBanana = productDao.findById(bananaId);

        assertFalse(readBanana.isPresent());
        assertTrue(readOrder.isPresent());
        assertTrue(readOrder1.isPresent());
        assertTrue(readFoods.isPresent());
        assertTrue(readShoes.isPresent());
        assertTrue(readCart.isPresent());
        assertTrue(readCart1.isPresent());

        try {
            groupDao.deleteAll();
            orderDao.deleteAll();
            cartDao.deleteAll();
        } catch (Exception e) {

        }
    }
}
