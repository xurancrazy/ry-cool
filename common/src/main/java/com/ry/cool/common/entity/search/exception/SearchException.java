/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.common.entity.search.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-17 上午11:43
 * <p>Version: 1.0
 */
public class SearchException extends NestedRuntimeException {

    public SearchException(String msg) {
        super(msg);
    }

    public SearchException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
