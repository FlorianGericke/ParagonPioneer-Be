package com.example.paragonPioneerBackend.Dto.response.mappers;

import com.example.paragonPioneerBackend.Entity.Good;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The GoodMapper class is a Spring component that implements the ResponseMapper interface.
 * It is used to map a Good entity to a GoodMapper object.
 * The GoodMapper object contains the properties of the Good entity.
 * The id, name, remarks, and slug are directly copied from the Good entity.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class GoodMapper implements ResponseMapper<GoodMapper, Good> {

    private String id;
    private String recipe;
    private String name;
    private String remarks;
    private String slug;

    /**
     * This method is used to map a Good entity to a GoodMapper object.
     * It uses the builder pattern to create a new GoodMapper object and sets its properties based on the properties of the Good entity.
     * The id, name, remarks, and slug are directly copied from the Good entity.
     *
     * @param input The Good entity to be mapped.
     * @return A new GoodMapper object with properties set based on the Good entity.
     */
    @Override
    public GoodMapper map(Good input) {
        return GoodMapper.builder()
                .id(input.getId().toString())
                .name(input.getName())
                .remarks(input.getRemarks())
                .slug(input.getSlug())
                .build();
    }
}