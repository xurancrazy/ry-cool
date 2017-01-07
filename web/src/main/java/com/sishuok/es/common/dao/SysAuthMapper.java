package com.sishuok.es.common.dao;

import com.sishuok.es.common.entity.SysAuth;

public interface SysAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAuth record);

    int insertSelective(SysAuth record);

    SysAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAuth record);

    int updateByPrimaryKey(SysAuth record);
}