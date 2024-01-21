package com.picksa.picksasync.originalApplication.repository;

import com.picksa.picksasync.originalApplication.domain.Part;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PartConverter implements AttributeConverter<Part, String> {

    @Override
    public String convertToDatabaseColumn(Part attribute) {
        if(attribute == null) return null;

        return attribute.getName();
    }

    @Override
    public Part convertToEntityAttribute(String name) {
        if(StringUtils.isBlank(name))
            return null;

        return Part.from(name);
    }

}
