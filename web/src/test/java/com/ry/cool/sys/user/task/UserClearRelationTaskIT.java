/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.sys.user.task;

import com.ry.cool.sys.organization.entity.Organization;
import com.ry.cool.sys.user.service.BaseUserIT;
import com.ry.cool.sys.organization.entity.Job;
import com.ry.cool.sys.organization.service.JobService;
import com.ry.cool.sys.organization.service.OrganizationService;
import com.ry.cool.sys.user.entity.User;
import com.ry.cool.sys.user.entity.UserOrganizationJob;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-5-18 下午2:18
 * <p>Version: 1.0
 */
public class UserClearRelationTaskIT extends BaseUserIT {


    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private JobService jobService;

    @Autowired
    private UserClearRelationTask userClearRelationTask;

    @Test
    public void testClearRelation() {
        User user = createDefaultUser();

        Organization organization1 = new Organization();
        organization1.setName("test1");
        Organization organization2 = new Organization();
        organization2.setName("test2");
        organizationService.save(organization1);
        organizationService.save(organization2);

        Job job1 = new Job();
        job1.setName("test1");
        Job job2 = new Job();
        job2.setName("test2");
        jobService.save(job1);
        jobService.save(job2);

        user.addOrganizationJob(new UserOrganizationJob(organization1.getId(), null));
        user.addOrganizationJob(new UserOrganizationJob(organization2.getId(), job1.getId()));
        user.addOrganizationJob(new UserOrganizationJob(organization2.getId(), job2.getId()));
        userService.update(user);

        //清除缓存
        clear();

        organizationService.delete(organization1);
        jobService.delete(job1);

        userClearRelationTask.clearDeletedUserRelation();

        clear();

        user = userService.findOne(user.getId());

        Assert.assertEquals(2, user.getOrganizationJobs().size());

        Assert.assertEquals(null, user.getOrganizationJobs().get(1).getJobId());


    }


}
