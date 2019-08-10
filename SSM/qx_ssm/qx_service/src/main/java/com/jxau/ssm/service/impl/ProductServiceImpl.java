package com.jxau.ssm.service.impl;

import com.jxau.ssm.dao.IProductDao;
import com.jxau.ssm.domain.Product;
import com.jxau.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 产品业务层
 */

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        productDao.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product,String id) throws Exception {
        productDao.updateProduct(product,id);
    }


    @Override
    public Product findById(String id) throws Exception {
        return productDao.findById(id);
    }

    @Override
    public void updateStatus(List list) throws Exception {
        productDao.updateStatus(list);
    }

    @Override
    public void updateDownStatus(List list) throws Exception {
        productDao.updateDownStatus(list);
    }

    @Override
    public void deleteProduct(List list) throws Exception {
        productDao.deleteProduct(list);
    }


}
