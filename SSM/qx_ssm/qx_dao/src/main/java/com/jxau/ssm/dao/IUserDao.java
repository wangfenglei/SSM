package com.jxau.ssm.dao;


import com.jxau.ssm.domain.Role;
import com.jxau.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws Exception
     */
    public UserInfo findByUsername(String username) throws Exception;


    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll(int page,int size) throws Exception;


    /**
     * 添加用户
     * @param userInfo
     * @throws Exception
     */
    void saveUser(UserInfo userInfo)throws Exception;

    /**
     * 根据id查找用户详细信息
     * @param username
     * @return
     * @throws Exception
     */
    UserInfo findById(String username) throws Exception;


    /**
     * 查找用户没有的角色
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId) throws Exception;


    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     */
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;



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
    public void delRoleForUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;


    /**
     *
     * 根据角色id 查用户
     */
    public UserInfo findByRoleId(String RoleId) throws Exception;


}
