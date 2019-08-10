package com.jxau.ssm;

import com.jxau.ssm.dao.IProductDao;
import com.jxau.ssm.domain.Product;
import com.jxau.ssm.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wfl
 * @date 2019/8/6 16:05
 * @description
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class daotest {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductDao productDao;

    @Test
    public void testfindAll() throws Exception {
        System.out.println("productService = " + productService);

        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.println("product = " + product.getProductName());
        }

    }

    @Test
    public void testfindAll2() throws Exception {
        System.out.println("productDao = " + productDao);

        List<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println("product = " + product.getProductName());
        }

    }
}
