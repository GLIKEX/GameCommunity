package com.gc.system.utils;

import com.gc.system.config.SnowFlake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class IdGenerator {
    private final SnowFlake snowflake;

    public IdGenerator(@Value("${snowflake.data-center-id}") long dataCenterId,
                       @Value("${snowflake.machine-id}") long machineId) {
        snowflake = new SnowFlake(dataCenterId, machineId);
    }

    public String generateId() {
        return String.valueOf(snowflake.nextId());
    }
}
