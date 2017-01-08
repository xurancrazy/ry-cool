/**
 * Copyright (c) 2005-2012 https://github.com/xurancrazy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ry.cool.maintain.notification.repository;

import com.ry.cool.common.repository.BaseRepository;
import com.ry.cool.maintain.notification.entity.NotificationData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-5-22 下午2:39
 * <p>Version: 1.0
 */
public interface NotificationDataRepository extends BaseRepository<NotificationData, Long> {

    @Modifying
    @Query("update NotificationData o set o.read=true where userId=?1")
    void markReadAll(Long userId);
}
