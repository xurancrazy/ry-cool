/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.sys.group.task;

import com.ry.cool.common.entity.search.SearchOperator;
import com.ry.cool.common.entity.search.Searchable;
import com.ry.cool.sys.group.entity.GroupType;
import com.ry.cool.sys.group.service.GroupRelationService;
import com.ry.cool.sys.group.entity.Group;
import com.ry.cool.sys.group.entity.GroupRelation;
import com.ry.cool.sys.group.service.GroupService;
import com.ry.cool.sys.organization.entity.Organization;
import com.ry.cool.sys.organization.service.OrganizationService;
import com.ry.cool.test.BaseIT;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-5-18 下午5:06
 * <p>Version: 1.0
 */
public class GroupClearRelationTaskIT extends BaseIT {

    @Autowired
    private GroupClearRelationTask groupClearRelationTask;

    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupRelationService groupRelationService;
    @Autowired
    private OrganizationService organizationService;

    @Test
    public void testClearDeletedGroupRelation() {
        Group group = new Group();
        group.setType(GroupType.organization);
        group.setShow(false);
        group.setName("123");
        groupService.save(group);

        Organization organization1 = new Organization();
        organization1.setName("test1");
        Organization organization2 = new Organization();
        organization2.setName("test2");
        organizationService.save(organization1);
        organizationService.save(organization2);

        GroupRelation groupRelation1 = new GroupRelation();
        groupRelation1.setGroupId(group.getId());
        groupRelation1.setOrganizationId(organization1.getId());
        GroupRelation groupRelation2 = new GroupRelation();
        groupRelation2.setGroupId(group.getId());
        groupRelation2.setOrganizationId(organization2.getId());

        groupRelationService.save(groupRelation1);
        groupRelationService.save(groupRelation2);

        Searchable searchable = Searchable.newSearchable();
        searchable.addSearchFilter("groupId", SearchOperator.eq, group.getId());
        Assert.assertEquals(2, groupRelationService.count());

        organizationService.delete(organization1);

        groupClearRelationTask.clearDeletedGroupRelation();
        Assert.assertEquals(1, groupRelationService.count());

        groupService.delete(group);
        groupClearRelationTask.clearDeletedGroupRelation();
        Assert.assertEquals(0, groupRelationService.count());

    }


}
