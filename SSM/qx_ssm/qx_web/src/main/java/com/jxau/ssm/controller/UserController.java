package com.jxau.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jxau.ssm.domain.Role;
import com.jxau.ssm.domain.UserInfo;
import com.jxau.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 用户表现层
 *
 */

@Controller
@RequestMapping(path = "/user")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name="size",required = true,defaultValue = "4")Integer size) throws Exception {

        ModelAndView mv = new ModelAndView();

        List<UserInfo> userList = userService.findAll(page, size);

        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }


    /**
     * 跳转到添加用户
     */

    @RequestMapping(path = "toAdd.do")
    @PreAuthorize("authentication.principal.username=='tom'")
    public String toAdd(){
        return "user-add";
    }


    /**
     * 添加用户
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/save.do")
    @PreAuthorize("authentication.principal.username=='tom'")   //只有tom用户能操作
    public String save(UserInfo userInfo)  {
        try {
            userService.save(userInfo);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        return "redirect:findAll.do";
    }


    /**
     * 查看用户详情
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return mv;

    }





    /**
     * 查询用户以及用户可以添加的角色
     * @param userid
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userid);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userid);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }



    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping(path = "/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) throws Exception {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }





    /**
     * 开启用户状态
     * @param id
     * @return
     */
    @RequestMapping(path = "/openStatus.do")
    @PreAuthorize("authentication.principal.username=='tom'")
    public String openStatus(String id) {
        List<String> list = new ArrayList<>();
        list = Arrays.asList(id.split(","));

        try {
            userService.updateStatus(list);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        System.out.println("开启成功");
        return "redirect:findAll.do";
    }


    /**
     * 关闭用户状态
     * @param id
     * @return
     */
    @RequestMapping(path = "/downStatus.do")
    @PreAuthorize("authentication.principal.username=='tom'")
    public String downStatus(String id)  {
        List<String> list = new ArrayList<>();
        list = Arrays.asList(id.split(","));

        try {
            userService.updateDownStatus(list);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        System.out.println("关闭成功");
        return "redirect:findAll.do";
    }


    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(path = "/deleteUser.do")
    @PreAuthorize("authentication.principal.username=='tom'")
    public String deletePro(String id)  {
        List<String> list = new ArrayList<>();
        list = Arrays.asList(id.split(","));

        try {
            userService.deleteUser(list);
        } catch (Exception e) {
            return "redirect:error.do";
        }
        System.out.println("删除成功!");

        return "redirect:findAll.do";
    }



    /**
     * 给用户删除角色
     * @param userId
     * @param roleId
     * @return
     */
    @RequestMapping(path = "/delRoleForUser.do")
    public String delRoleForUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "roleId", required = true) String roleId) throws Exception {

        userService.delRoleForUser(userId, roleId);
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
