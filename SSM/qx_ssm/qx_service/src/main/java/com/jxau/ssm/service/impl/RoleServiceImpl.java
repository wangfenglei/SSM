package com.jxau.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.jxau.ssm.dao.IRoleDao;
import com.jxau.ssm.domain.Permission;
import com.jxau.ssm.domain.Role;
import com.jxau.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 角色业务层实现
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    /**
     *
     * @param role
     */
    @Override
    public void save(Role role) throws Exception {
        roleDao.saveRole(role);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Role> findAll(int page ,int size) throws Exception {

        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }


    @Override
    public void deleteRoleById(String roleId) throws Exception {
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void delPermissionForRole(String permissionId, String roleId) throws Exception {
        roleDao.delPermissionForRole(permissionId, roleId);
    }

}
