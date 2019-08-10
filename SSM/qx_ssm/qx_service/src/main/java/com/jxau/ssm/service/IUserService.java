package com.jxau.ssm.service;

import com.jxau.ssm.domain.Role;
import com.jxau.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 用户认证业务层层接口
 */

public interface IUserService extends UserDetailsService {

    /**
     * 查询所有用户
     * @return
     */
    public List<UserInfo> findAll(int page,int size) throws Exception;

    /**
     * 插入用户
     * @param userInfo
     * @throws Exception
     */
    void save(UserInfo userInfo) throws Exception;


    /**
     *
     * 根据id查找用户
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findById(String id) throws Exception;


    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(String userId, String[] roleIds) throws Exception;


    /**
     * 查找自身没有的角色
     * @param userid
     * @return
     */
    List<Role> findOtherRoles(String userid) throws Exception;



    /**
     * 开启用户状态
     * @throws Exception
     */
    public  void  updateStatus(List list)throws Exception;

    /**
     * 关闭用户状态
     * @throws Exception
     */
    public  void  updateDownStatus(List list)throws Exception;

    /**
     * 删除用户
     * @throws Exception
     */
    public  void  deleteUser(List list)throws Exception;

    /**
     * 用户删除角色
     * @param userId
     * @param roleId
     */
    public void delRoleForUser( String userId, String roleId) throws Exception;
}
