package com.jxau.ssm.service;

import com.jxau.ssm.domain.Orders;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 * 订单业务层接口
 */
public interface IOrderService {


    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */

    public List<Orders> findAll() throws Exception;

    /**
     * 分页查询所有订单
     * @return
     * @throws Exception
     */

    public List<Orders> findPageAll(int page,int size) throws Exception;


    /**
     * 根据订单编号查询订单
     * @param orderNum
     * @return
     */
    public Orders findByNum(String orderNum) throws Exception;


    /**
     * 根据Id查询订单
     * @param id
     * @return
     */
    public Orders findById(String id) throws Exception;

    /**
     *根据产品Id查询订单详情
     *@param productId
     *
     */
    public List<Orders> findByProductId(String productId,int page,int size) throws Exception;

}
