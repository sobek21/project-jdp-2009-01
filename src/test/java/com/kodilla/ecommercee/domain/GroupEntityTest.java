package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupDao;
import com.kodilla.ecommercee.repository.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTest {
    @Autowired
    private GroupDao groupDao;

    @Autowired
    private ProductDao productDao;

    @Test
    public void testGroupDaoCreateReadSaveAndDelete() {
        Group group = new Group("testGroup");

        groupDao.save(group);
        long id = group.getId();
        Optional<Group> readGroup = groupDao.findById(id);

        Assert.assertTrue(readGroup.isPresent());

        groupDao.deleteById(id);

        readGroup = groupDao.findById(id);
        Assert.assertFalse(readGroup.isPresent());

    }

    @Test
    public void testRelationshipBetweenGroupAndProduct() {
        Group group = new Group("testGroup");
        Product product = new Product("banan", 20, 1);
        Product product1 = new Product("jablko", 30, 1);

        group.getProducts().add(product);
        group.getProducts().add(product1);
        product.setGroup(group);
        product1.setGroup(group);

        groupDao.save(group);
        long groupId = group.getId();
        long groupIdFromProduct = product.getGroup().getId();
        long productId = product.getProductId();
        long product1Id = product1.getProductId();
        Optional<Group> readGroup = groupDao.findById(groupId);
        Optional<Product> readProduct = productDao.findById(product1Id);

        Assert.assertNotEquals(0, groupId);
        Assert.assertEquals(groupId, groupIdFromProduct);

        productDao.deleteById(productId);

        Assert.assertTrue(readGroup.isPresent());

        groupDao.deleteById(groupId);

        Assert.assertTrue(readProduct.isPresent());
    }

    @Test
    public void testGroupDaoUpdate() {
        Group group = new Group("testGroup");

        groupDao.save(group);
        long id = group.getId();

        Assert.assertEquals("testGroup", group.getGroupName());

        group.setGroupName("testGroupUpdate");

        Assert.assertEquals("testGroupUpdate", group.getGroupName());

        groupDao.deleteById(id);
    }
}