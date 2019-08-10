package com.jxau.ssm.dao;

import com.jxau.ssm.domain.Orders;
import java.util.List;

/**
 * 订单持久层
 */

public interface IOrdersDao {


    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */

    public List<Orders> findAll() throws Exception;


    /**
     * 根据订单编号查询订单
     * @param orderNum
     * @return
     */
    public Orders findByNum(String orderNum) throws Exception;


    /**
     * 根据Id查询订单详情
     * @param id
     * @return
     */
    public Orders findById(String id) throws Exception;


    /**
     *根据产品Id查询订单详情
     *@param productId
     *
     */
    public List<Orders> findByProductId(String productId) throws Exception;


}
