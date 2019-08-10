package com.jxau.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jxau.ssm.domain.Orders;
import com.jxau.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 订单表现层
 */

@Controller("orderController")
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findAll.do")
    @RolesAllowed({"ADMIN","USER","TEST"})  //JSR250
    public ModelAndView findAllOrder() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Orders> orderList = orderService.findAll();

        mv.addObject("ordersList",orderList);
        mv.setViewName("orders-list");
        return mv;
    }

    /**
     * 查询所有订单 分页
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findPageAll.do")
    public ModelAndView findPageAllOrder(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name="size",required = true,defaultValue = "4")Integer size) {
        ModelAndView mv = new ModelAndView();

        List<Orders> orderList = null;
        try {
            orderList = orderService.findPageAll(page,size);
        } catch (Exception e) {
            mv.setViewName("error");
            return mv;
        }

        PageInfo pageInfo = new PageInfo(orderList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }


    /**
     * 根据订单号查找订单
     * @param orderNum
     * @return
     */
    @RequestMapping(path = "/findByNum.do")
    public ModelAndView findByNum(@RequestParam(name = "orderNum" ,required = true)String orderNum){

        System.out.println("orderNum = " + orderNum);
        ModelAndView mv = new ModelAndView();

        Orders orders = null;
        try {
            orders = orderService.findByNum(orderNum);
        } catch (Exception e) {
            mv.setViewName("error");
            return mv;
        }
        //System.out.println("orderList = " + orders);
        mv.addObject("orders",orders);
        mv.setViewName("orders-list1");
        return mv;
    }



    /**
     * 根据订单Id查找订单
     * @param id
     * @return
     */
    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(@RequestParam(name = "id" ,required = true) String id){

        ModelAndView mv = new ModelAndView();

        Orders orders = null;
        try {
            orders = orderService.findById(id);
        } catch (Exception e) {
            mv.setViewName("error");
            return mv;
        }
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }


    /**
     *根据产品Id查询订单详情
     *@param productId
     *
     */
    @RequestMapping(path = "/findByProductId.do")
    public ModelAndView findByProductId(String productId,@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name="size",required = true,defaultValue = "4")Integer size)  {
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = null;
        try {
            orders = orderService.findByProductId(productId,page,size);
        } catch (Exception e) {
            mv.setViewName("error");
            return mv;
        }

        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("productId",productId);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list-productId");
        return mv;
    }


    /**
     * 跳转出错界面
     * @return
     */
    @RequestMapping(path = "/error.do")
    public String error(){

        return "error";
    }


}
