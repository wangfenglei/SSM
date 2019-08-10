package com.jxau.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.jxau.ssm.domain.Permission;
import com.jxau.ssm.domain.Role;
import com.jxau.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(path = "/role")
@Controller
public class RoleController {

    @Autowired
    private IRoleService roleService;



    /**
     * 跳转到添加角色
     */

    @RequestMapping(path = "/toAdd.do")
    public String toAdd(){
        return "role-add";
    }


    /**
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/save.do")
    public String save(Role role) {
        try {
            roleService.save(role);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        return "redirect:findAll.do";
    }

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name="size",required = true,defaultValue = "4")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll(page,size);

        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role-list");
        return mv;
    }


    //删除角色
    @RequestMapping(path = "/deleteRole.do")
    public String deleteRole(@RequestParam(name="id",required = true) String roleId)  {
        try {
            roleService.deleteRoleById(roleId);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        return "redirect:findAll.do";
    }

    //角色详情查询
    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);

        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }



    //给角色添加权限
    @RequestMapping(path = "/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds)  {
        try {
            roleService.addPermissionToRole(roleId, permissionIds);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        return "redirect:findAll.do";
    }


    //给角色删除权限
    @RequestMapping(path = "/delPermissionForRole.do")
    public String delPermissionForRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "permissionId", required = true) String permissionId) throws Exception {

        roleService.delPermissionForRole(permissionId,roleId);

        return "redirect:findAll.do";
    }



    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping(path = "/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
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
