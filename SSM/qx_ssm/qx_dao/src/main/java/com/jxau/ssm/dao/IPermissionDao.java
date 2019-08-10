package com.jxau.ssm.dao;

import com.jxau.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {


    /**
     * 根据角色id 查找权限
     * @param id
     * @return
     * @throws Exception
     */
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    /**
     * 查找所有权限
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;


    /**
     * 插入权限
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;


    /**
     * 根据id查找权限
     * @param id
     * @return
     * @throws Exception
     */
    //@Select("select * from permission where id=#{id}")
    Permission findById(String id) throws Exception;


    /**
     * 根据权限id删除权限角色关联
     * @param id
     * @throws Exception
     */
    //@Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(String id) throws Exception;


    /**
     *
     * @param id
     * @throws Exception
     */
    //@Delete("delete from permission where id=#{id}")
    void deleteById(String id) throws Exception ;


    /**
     *查询权限详细信息
     * @param id
     * @return
     */
    Permission findPermissionMany(String id) throws Exception;


    /**
     * 删除权限
     */

    public  void  deletePermission(List list)throws Exception;
}
