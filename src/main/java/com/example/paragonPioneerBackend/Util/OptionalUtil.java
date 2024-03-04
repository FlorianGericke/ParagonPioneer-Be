package com.example.paragonPioneerBackend.Util;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import java.util.Optional;

public class OptionalUtil {

    public static String getIdOrEmpty(Optional<? extends BaseEntity> entity) {
        if (entity.isEmpty()) {
            return "";
        }

        var baseEntity = entity.get();
        return baseEntity.getId().toString();
    }
}
