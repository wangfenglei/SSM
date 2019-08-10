package com.jxau.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.jxau.ssm.dao.IUserDao;
import com.jxau.ssm.domain.Role;
import com.jxau.ssm.domain.UserInfo;
import com.jxau.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 * 用户认证业务层实现
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //封装user  让spring-serurity 拿到用户名密码
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));

        System.out.println(user.toString());
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


    /**
     *
     * @return
     */
    @Override
    public List<UserInfo> findAll(int page,int size) throws Exception {

        PageHelper.startPage(page,size);
        return userDao.findAll(page, size);
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.saveUser(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }




    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }

    }


    @Override
    public List<Role> findOtherRoles(String userid) throws Exception {
        return userDao.findOtherRoles(userid);
    }



    //*****
    @Override
    public void updateStatus(List list) throws Exception {
        userDao.updateStatus(list);
    }

    @Override
    public void updateDownStatus(List list) throws Exception {
        userDao.updateDownStatus(list);
    }

    @Override
    public void deleteUser(List list) throws Exception {
        userDao.deleteUser(list);
    }

    @Override
    public void delRoleForUser(String userId, String roleId) throws Exception {
        userDao.delRoleForUser(userId,roleId);
    }
}
