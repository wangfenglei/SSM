package com.jxau.ssm.controller;

import com.jxau.ssm.domain.Product;
import com.jxau.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 产品表现层
 */
@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 查询所有产品   只有ADMIN权限可以操作
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findAll.do")
    @RolesAllowed("ADMIN")

    public ModelAndView finfAll() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list1");
        for (Product product : products) {
            System.out.println("product = " + product.getDepartureTime()+"---"+product.getDepartureTimeStr());
        }
        return mv;
    }

    /**
     * 跳转添加商品
     * @return
     */
    @RequestMapping(path = "/toProduct_add.do")
    public String toProduct_add(){
        return "product-add";
    }


    /**
     * 添加商品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/save.do")
    public String saveProduct(Product product)  {
        try {
            productService.saveProduct(product);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        return "redirect:findAll.do";
    }



    /**
     * 跳转更新商品页面
     * @return
     */
    @RequestMapping(path = "/toedit.do")
    public ModelAndView toedit(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-edit");
        return mv;
    }

    /**
     * 更新商品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/updateProduct.do")
    public String updateProduct(Product product,String id)  {
        try {
            productService.updateProduct(product,id);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        return "redirect:findAll.do";
    }

    /**
     * 查看商品详情
     * @return
     */
    @RequestMapping(path = "/todetails.do")
    public ModelAndView todetails(String id ) throws Exception {

        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-details");
        return mv;
    }

    /**
     * 开启产品状态
     * @param id
     * @return
     */
    @RequestMapping(path = "/openStatus.do")
    public String openStatus(String id)  {
        List<String> list = new ArrayList<>();
        list = Arrays.asList(id.split(","));
        try {
            productService.updateStatus(list);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        System.out.println("开启成功");
        return "redirect:findAll.do";
    }


    /**
     * 关闭产品状态
     * @param id
     * @return
     */
    @RequestMapping(path = "/downStatus.do")
    public String downStatus(String id)  {
        List<String> list = new ArrayList<>();
        list = Arrays.asList(id.split(","));

        try {
            productService.updateDownStatus(list);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        System.out.println("关闭成功");
        return "redirect:findAll.do";
    }


    /**
     * 删除产品
     * @param id
     * @return
     */
    @RequestMapping(path = "/deletePro.do")
    public String deletePro(String id) {
        List<String> list = new ArrayList<>();
        list = Arrays.asList(id.split(","));

        try {
            productService.deleteProduct(list);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        System.out.println("删除成功!");

        return "redirect:findAll.do";
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
