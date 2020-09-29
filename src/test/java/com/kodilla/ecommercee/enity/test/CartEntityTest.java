package com.kodilla.ecommercee.enity.test;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.repository.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartEntityTest {
    @Autowired
    CartDao cartDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProductDao productDao;

    @Test
    public void testCartDaoSave() {
        //Given
        Cart cart = new Cart();

        //When
        cartDao.save(cart);

        //Then
        long id = cart.getCartId();
        Optional<Cart> readCart = cartDao.findById(id);
        Assert.assertTrue(readCart.isPresent());

        //CleanUp
        cartDao.deleteById(id);
    }

    @Test
    public void testRelationBetweenUserAndCart() {
        //Given
        Cart cart = new Cart();

        User user = new User();
        user.setUserKey(12345);
        user.setUsername("Username");
        user.setPassword("Password");
        user.setCart(cart);

        cart.setUser(user);

        //When
        cartDao.save(cart);
        long id = user.getCart().getCartId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        cartDao.deleteById(id);
    }

    @Test
    public void testRelationsBetweenProductAndCart() {
        //Given
        Cart cart = new Cart();
        Cart cart1 = new Cart();
        Product product = new Product();
        Product product1 = new Product();
        Product product2 = new Product();

        product.setProductName("product");
        product.setProductPrice(10);
        product.setQuantity(100);

        product1.setProductName("product1");
        product1.setProductPrice(13);
        product1.setQuantity(150);

        product2.setProductName("product2");
        product2.setProductPrice(15);
        product2.setQuantity(1000);

        cart.getProducts().add(product);
        cart.getProducts().add(product1);
        cart1.getProducts().add(product2);
        cart1.getProducts().add(product);

        product.getCarts().add(cart);
        product.getCarts().add(cart1);
        product1.getCarts().add(cart);
        product2.getCarts().add(cart1);

        //When
        cartDao.save(cart);
        long id = cart.getCartId();
        cartDao.save(cart1);
        long id1 = cart1.getCartId();

        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertNotEquals(1, id1);

        //CleanUp
        try {
            cartDao.deleteById(id);
            cartDao.deleteById(id1);
        } catch (Exception e) {

        }
    }
}
