package com.zking.ssm.mapper;

import com.zking.ssm.model.SysRple;

public interface SysRpleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(SysRple record);

    int insertSelective(SysRple record);

    SysRple selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(SysRple record);

    int updateByPrimaryKey(SysRple record);
}