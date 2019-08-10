package com.jxau.ssm.service;

import com.jxau.ssm.domain.Permission;
import com.jxau.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 角色业务测接口
 */
public interface IRoleService {


    /**
     * 保存角色
     * @param role
     */
    void save(Role role) throws Exception;

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll(int page ,int size) throws Exception;


    /**
     * 删除角色
     * @param roleId
     */
    void deleteRoleById(String roleId) throws Exception;

    /**
     * 根据id查询角色
     * @param roleId
     * @return
     */
    Role findById(String roleId) throws Exception;


    /**
     * 添加权限
     * @param roleId
     * @param permissionIds
     */
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;


    /**
     * 查询角色可以添加的权限
     * @param roleId
     * @return
     */
    List<Permission> findOtherPermissions(String roleId) throws Exception;


    /**
     * 删除角色的权限
     * @param permissionId
     * @param roleId
     */
    public void delPermissionForRole(@Param("permissionId") String permissionId, @Param("roleId") String roleId) throws Exception;
}
