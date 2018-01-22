package com.hub.data.springdataexample.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @author Dmitriy Lyashenko
 */
@Converter
public class LocalDataTimeConverter implements AttributeConverter<LocalDateTime, Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDateTime attribute) {
        return Date.valueOf(attribute.toLocalDate());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        return dbData.toLocalDate().atStartOfDay();
    }
}
