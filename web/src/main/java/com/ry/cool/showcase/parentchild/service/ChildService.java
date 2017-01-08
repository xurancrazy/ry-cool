/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.showcase.parentchild.service;

import com.ry.cool.common.service.BaseService;
import com.ry.cool.showcase.parentchild.entity.Child;
import com.ry.cool.showcase.parentchild.repository.ChildRepository;
import com.ry.cool.showcase.parentchild.entity.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-2-4 下午3:01
 * <p>Version: 1.0
 */
@Service
public class ChildService extends BaseService<Child, Long> {

    private ChildRepository getChildRepository() {
        return (ChildRepository) baseRepository;
    }


    public ChildService() {
    }

    public Page<Child> findByParent(Parent parent, Pageable pageable) {
        return getChildRepository().findByParent(parent, pageable);
    }

    Page<Child> findByParents(List<Parent> parents, Pageable pageable) {
        return getChildRepository().findByParents(parents, pageable);
    }


    public void deleteByParent(Parent parent) {
        getChildRepository().deleteByParent(parent);
    }
}
