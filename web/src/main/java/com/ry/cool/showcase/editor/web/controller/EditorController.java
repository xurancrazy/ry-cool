/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.showcase.editor.web.controller;

import com.ry.cool.common.web.controller.BaseCRUDController;
import com.ry.cool.showcase.editor.entity.Editor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-28 下午4:29
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/showcase/editor")
public class EditorController extends BaseCRUDController<Editor, Long> {

    public EditorController() {
        setResourceIdentity("showcase:editor");
    }

    /**
     * 验证失败返回true
     *
     * @param m
     * @param result
     * @return
     */
    @Override
    protected boolean hasError(Editor m, BindingResult result) {
        Assert.notNull(m);

        return result.hasErrors();
    }


}
