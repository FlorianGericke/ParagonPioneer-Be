package com.example.paragonPioneerBackend.Util;

import com.example.paragonPioneerBackend.Entity.BaseEntity;
import java.util.Optional;

public class OptionalUtil {

    public static <T extends BaseEntity> String getIdOrEmpty(T entity) {
        if (entity == null) {
            return "";
        }

        return entity.getId().toString();
    }

}
