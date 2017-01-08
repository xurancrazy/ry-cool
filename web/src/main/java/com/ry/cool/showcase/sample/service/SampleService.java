/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.showcase.sample.service;

import com.ry.cool.common.service.BaseService;
import com.ry.cool.showcase.sample.entity.Sample;
import com.ry.cool.showcase.sample.repository.SampleRepository;
import org.springframework.stereotype.Service;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-2-4 下午3:01
 * <p>Version: 1.0
 */
@Service
public class SampleService extends BaseService<Sample, Long> {

    private SampleRepository getSampleRepository() {
        return (SampleRepository) baseRepository;
    }


    public Sample findByName(String name) {
        return getSampleRepository().findByName(name);
    }

}
