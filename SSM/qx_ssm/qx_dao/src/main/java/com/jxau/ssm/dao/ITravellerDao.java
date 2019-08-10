package com.jxau.ssm.dao;

import com.jxau.ssm.domain.Traveller;

import java.util.List;

public interface ITravellerDao {

    /**
     * 根据订单Id查找游客
     * @param ordersId
     * @return
     * @throws Exception
     */
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;


}
