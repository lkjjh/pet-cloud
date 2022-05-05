package com.al.pet.service.impl;

import com.al.pet.service.RedisKeyService;
import com.al.pet.util.Constants;
import com.al.pet.util.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author al
 * @version 1.0
 */
@Service
public class RedisKeyServiceImpl implements RedisKeyService {
    @Autowired
    private Constants.System system;

    @Override
    public String getKey(String prefix, Object... args) {
        return RedisKeyUtils.getKey(prefix, args);
    }

    @Override
    public String getPmsKey(Object... args) {
        return getKey(system.getPms(), args);
    }

    @Override
    public String getOmsKey(Object... args) {
        return getKey(system.getOms(), args);
    }

    @Override
    public String getUmsKey(Object... args) {
        return getKey(system.getUms(), args);
    }
}
