//package com.kodilla.ecommercee.entity.test;
//
//import com.kodilla.ecommercee.domain.Cart;
//import com.kodilla.ecommercee.domain.Order;
//import com.kodilla.ecommercee.domain.Product;
//import com.kodilla.ecommercee.domain.User;
//import com.kodilla.ecommercee.repository.OrderDao;
//import com.kodilla.ecommercee.repository.ProductRepository;
//import com.kodilla.ecommercee.repository.UserDao;
//import org.junit.Assert;
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
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class OrderEntityTestSuite {
//    @Autowired
//    OrderDao orderDao;
//
//    @Autowired
//    UserDao userDao;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    public void testOrderDaoFindAllOrders() {
//        //Given
//        Cart piotrCart = new Cart();
//        Cart adminCart = new Cart();
//        Cart userCart = new Cart();
//
//        User piotr = new User(1L, 59403L, "Piotr", "jsmith123");
//        User admin = new User(2L, 96997L, "Admin", "admin123");
//        User user = new User(3L, 31251L, "User", "admin123");
//
//        piotr.setCart(piotrCart);
//        admin.setCart(adminCart);
//        user.setCart(userCart);
//
//        List<Product> piotrProducts = new ArrayList<>();
//        List<Product> adminProducts = new ArrayList<>();
//        List<Product> userProducts = new ArrayList<>();
//
//        Product kurtkaZimowa = new Product(1L, "kurtka zimowa",
//                100.0, 1);
//        Product plaszcz = new Product(2L, "płaszcz",
//                150.0, 1);
//        Product buty = new Product(3L, "buty",
//                100, 2);
//        Product rekawiczki = new Product(4L, "rękawiczki",
//                50, 2);
//        Product sandaly = new Product(5L, "sandały",
//                80, 2);
//        Product zegarek = new Product(6L, "zegarek",
//                250, 2);
//        Product kolczyki = new Product(7L, "złote kolczyki",
//                300, 2);
//        Product krawat = new Product(8L, "krawat",
//                50, 2);
//        Product szelki = new Product(9L, "szelki",
//                40, 2);
//        Product pasek = new Product(10L, "pasek",
//                100, 2);
//        Product koszulka = new Product(11L, "koszulka",
//                50, 2);
//        Product bezrekawnik = new Product(12L, "bezrękawnik",
//                30, 2);
//        Product apaszka = new Product(13L, "apaszka",
//                20, 2);
//
//        productRepository.save(kurtkaZimowa);
//        productRepository.save(plaszcz);
//        productRepository.save(buty);
//        productRepository.save(rekawiczki);
//        productRepository.save(sandaly);
//        productRepository.save(zegarek);
//        productRepository.save(kolczyki);
//        productRepository.save(krawat);
//        productRepository.save(szelki);
//        productRepository.save(pasek);
//        productRepository.save(koszulka);
//        productRepository.save(bezrekawnik);
//        productRepository.save(apaszka);
//
//        piotrProducts.add(plaszcz);
//        piotrProducts.add(buty);
//        piotrProducts.add(rekawiczki);
//        piotrProducts.add(zegarek);
//        piotrProducts.add(pasek);
//
//        adminProducts.add(kurtkaZimowa);
//        adminProducts.add(rekawiczki);
//        adminProducts.add(koszulka);
//
//        userProducts.add(zegarek);
//        userProducts.add(krawat);
//        userProducts.add(szelki);
//        userProducts.add(pasek);
//
//        piotrCart.setProducts(piotrProducts);
//        adminCart.setProducts(adminProducts);
//        userCart.setProducts(userProducts);
//
//        Order piotrOrder = new Order();
//        Order adminOrder = new Order(admin, adminProducts);
//        Order userOrder = new Order(user, userProducts);
//        piotrOrder.setUser(piotr);
//        piotrOrder.setProducts(piotrProducts);
//
//        adminOrder.setUser(admin);
//        adminOrder.setProducts(adminProducts);
//
//        userOrder.setUser(user);
//        userOrder.setProducts(userProducts);
//
//        orderDao.save(piotrOrder);
//        orderDao.save(adminOrder);
//        orderDao.save(userOrder);
//
//
//        long pId = piotrOrder.getOrderId();
////        Optional<Order> piotrOrderId = orderDao.findById(pId);
//        long aId = adminOrder.getOrderId();
////        Optional<Order> adminOrderId = orderDao.findById(aId);
//        long uId = userOrder.getOrderId();
////        Optional<Order> userOrderId = orderDao.findById(uId);
//
//        try {
//            Assert.assertEquals(Optional.of(1), piotrOrder.getOrderId());
//            Assert.assertEquals(Optional.of(2), adminOrder.getOrderId());
//            Assert.assertEquals(Optional.of(3), userOrder.getOrderId());
//        } finally {
//            orderDao.deleteAll();
//            productRepository.deleteAll();
//            userDao.deleteAll();
//        }
//    }
//}
