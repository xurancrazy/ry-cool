/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.common.repository.callback;

import com.ry.cool.common.entity.search.Searchable;

import javax.persistence.Query;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-16 下午8:10
 * <p>Version: 1.0
 */
public final class NoneSearchCallback implements SearchCallback {

    @Override
    public void prepareQL(StringBuilder ql, Searchable search) {
    }

    @Override
    public void prepareOrder(StringBuilder ql, Searchable search) {
    }

    @Override
    public void setValues(Query query, Searchable search) {
    }

    @Override
    public void setPageable(Query query, Searchable search) {
    }
}
