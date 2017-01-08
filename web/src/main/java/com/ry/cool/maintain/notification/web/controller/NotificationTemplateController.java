/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.maintain.notification.web.controller;

import com.ry.cool.common.entity.search.Searchable;
import com.ry.cool.common.web.bind.annotation.PageableDefaults;
import com.ry.cool.common.web.bind.annotation.SearchableDefaults;
import com.ry.cool.common.web.controller.BaseCRUDController;
import com.ry.cool.common.web.validate.ValidateResponse;
import com.ry.cool.maintain.notification.entity.NotificationTemplate;
import com.ry.cool.maintain.notification.service.NotificationTemplateService;
import com.ry.cool.maintain.notification.entity.NotificationSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-28 下午4:29
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/admin/maintain/notification/template")
public class NotificationTemplateController extends BaseCRUDController<NotificationTemplate, Long> {

    private NotificationTemplateService getNotificationTemplateService() {
        return (NotificationTemplateService) baseService;
    }

    public NotificationTemplateController() {
        setResourceIdentity("maintain:notificationTemplate");
    }

    @Override
    protected void setCommonData(Model model) {
        model.addAttribute("notificationSystems", NotificationSystem.values());
    }


    @Override
    @RequestMapping(method = RequestMethod.GET)
    @PageableDefaults(sort = "id=desc")
    @SearchableDefaults(value = "deleted_eq=true", merge = true)
    public String list(Searchable searchable, Model model) {
        return super.list(searchable, model);
    }

    /**
     * 验证失败返回true
     *
     * @param m
     * @param result
     * @return
     */
    @Override
    protected boolean hasError(NotificationTemplate m, BindingResult result) {
        Assert.notNull(m);

        NotificationTemplate template = getNotificationTemplateService().findByName(m.getName());
        if (template == null || (template.getId().equals(m.getId()) && template.getName().equals(m.getName()))) {
            //success
        } else {
            result.rejectValue("name", "该名称已被其他模板使用");
        }

        return result.hasErrors();
    }

    /**
     * 验证返回格式
     * 单个：[fieldId, 1|0, msg]
     * 多个：[[fieldId, 1|0, msg],[fieldId, 1|0, msg]]
     *
     * @param fieldId
     * @param fieldValue
     * @return
     */
    @RequestMapping(value = "validate", method = RequestMethod.GET)
    @ResponseBody
    public Object validate(
            @RequestParam("fieldId") String fieldId, @RequestParam("fieldValue") String fieldValue,
            @RequestParam(value = "id", required = false) Long id) {
        ValidateResponse response = ValidateResponse.newInstance();

        if ("name".equals(fieldId)) {
            NotificationTemplate template = getNotificationTemplateService().findByName(fieldValue);
            if (template == null || (template.getId().equals(id) && template.getName().equals(fieldValue))) {
                //如果msg 不为空 将弹出提示框
                response.validateSuccess(fieldId, "");
            } else {
                response.validateFail(fieldId, "该名称已被其他模板使用");
            }
        }
        return response.result();
    }


}
