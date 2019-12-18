package com.zking.ssm.mapper;

import com.zking.ssm.model.SysUser;

import java.util.Set;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //根据用户名查账号信息
    SysUser listUserByName(String username);

    //根据用户名查角色名字
    Set<String> listRolesByUserName(String username);

    //根据用户名查权限名字
    Set<String> listPermissionsByUserName(String username);
}