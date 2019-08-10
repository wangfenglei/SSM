package com.jxau.ssm.dao;

import com.jxau.ssm.domain.Permission;
import com.jxau.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {


    /**
     * 根据用户id查询出所有对应的角色
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> findRoleByUserId(String userId) throws Exception;


    /**
     * 询出所有角色
     * @return
     */
    List<Role> findAll() throws Exception;

    /**
     * 保存角色
     * @param role
     */
    void saveRole(Role role) throws Exception;




    /**
     * 查询角色详细信息
     * @param roleId
     * @return
     */
    Role findById(String roleId) throws Exception;


    /**
     * 查询角色1可以再添加的权限
     * @param roleId
     * @return
     */
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionId
     */
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;


    /**
     * 删除用户的角色
     * @param roleId
     */
    void deleteFromUser_RoleByRoleId(String roleId) throws Exception;


    /**
     * 删除角色全部的权限
     * @param roleId
     */
    void deleteFromRole_PermissionByRoleId(String roleId) throws Exception;


    /**
     * 删除角色
     * @param roleId
     */
    void deleteRoleById(String roleId) throws Exception;

    /**
     * 删除角色的权限
     * @param permissionId
     * @param roleId
     */
    public void delPermissionForRole(@Param("permissionId") String permissionId, @Param("roleId") String roleId) throws Exception;


    /**
     * 根据权限id 查角色
     * @param permissionId
     * @return
     */
    Role findByIdUser(String permissionId) throws Exception;

}
