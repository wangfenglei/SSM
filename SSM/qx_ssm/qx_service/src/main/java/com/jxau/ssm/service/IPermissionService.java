package com.jxau.ssm.service;

import com.jxau.ssm.domain.Permission;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 */
public interface IPermissionService {

    /**
     *
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;


    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    List<Permission> findAll(int page,int size) throws Exception;


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
