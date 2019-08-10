package com.jxau.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jxau.ssm.domain.Permission;
import com.jxau.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path = "/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;


    /**
     * 跳转到添加权限
     */

    @RequestMapping(path = "toAdd.do")
    public String toAdd(){
        return "permission-add";
    }


    /**
     * 添加权限
     * @param permission
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/save.do")
    public String save(Permission permission) {
        try {
            permissionService.save(permission);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        return "redirect:findAll.do";
    }

    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name="size",required = true,defaultValue = "4")Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = permissionService.findAll(page,size);

        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }


    /**
     *
     *
     * 查询有此权限的角色和用户
     */

    @RequestMapping(path = "/findPermissionMany.do")
    public ModelAndView findPermissionMany(String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Permission permission = permissionService.findPermissionMany(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-show");
        return mv;
    }


    /**
     * 删除权限
     * @return
     */
    @RequestMapping(path = "/deletePermission.do")
    public String deletePermission(String id){
        List<String> list = new ArrayList<>();
        list = Arrays.asList(id.split(","));
        try {
            permissionService.deletePermission(list);
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
