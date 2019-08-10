package com.jxau.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.jxau.ssm.dao.IOrdersDao;
import com.jxau.ssm.domain.Orders;
import com.jxau.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 订单业务层接口实现
 */

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    @Override
    public List<Orders> findPageAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findByNum(String orderNum) throws Exception {
        return ordersDao.findByNum(orderNum);
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }

    @Override
    public List<Orders> findByProductId(String productId,int page,int size) throws Exception {

        PageHelper.startPage(page,size);
        return ordersDao.findByProductId(productId);
    }
}
