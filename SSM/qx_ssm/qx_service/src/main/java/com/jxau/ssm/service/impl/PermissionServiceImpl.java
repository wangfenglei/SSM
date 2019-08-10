package com.jxau.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.jxau.ssm.dao.IPermissionDao;
import com.jxau.ssm.dao.IProductDao;
import com.jxau.ssm.domain.Permission;
import com.jxau.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 */

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public void save(Permission permission) throws Exception {

        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findAll(int page,int size) throws Exception {

        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    @Override
    public Permission findPermissionMany(String id) throws Exception {
        return permissionDao.findPermissionMany(id);
    }

    @Override
    public void deletePermission(List list) throws Exception {
        permissionDao.deletePermission(list);
    }
}
