/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.common.repository;

import com.ry.cool.common.entity.BaseInfo;
import com.ry.cool.common.entity.SchoolInfo;
import com.ry.cool.common.entity.User;
import com.ry.cool.common.entity.search.Searchable;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * <p>用户仓库</p>
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-14 下午2:18
 * <p>Version: 1.0
 */
public interface UserRepository2 extends BaseRepository<User, Long> {


    ////////////////////////////////////////////////////
    /////////以下实现都委托给UserRepository2Impl///////
    ////////////////////////////////////////////////////

    public BaseInfo findBaseInfoByUserId(Long userId);

    public List<SchoolInfo> findAllSchoolTypeByUserId(Long userId);

    public Page<User> findAllByDefault(final Searchable searchable);

    public long countAllByDefault(final Searchable searchable);

    public long countAllByCustom(final Searchable searchable);

    public Page<User> findAllByCustom(final Searchable searchable);

}
