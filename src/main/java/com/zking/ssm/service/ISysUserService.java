package com.zking.ssm.service;

import com.zking.ssm.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public interface ISysUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser listUserByName(String username);

    //根据用户名查角色名字
    Set<String> listRolesByUserName(String username);

    //根据用户名查权限名字
    Set<String> listPermissionsByUserName(String username);

}