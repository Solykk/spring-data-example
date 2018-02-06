package com.hub.data.springdataexample.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hub.data.springdataexample.domain.entities.First;

import java.time.format.DateTimeFormatter;

/**
 * @author Dmitriy Lyashenko
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FirstDTO {

    private String name;
    private String description;
    private String updatedAt;

    public FirstDTO() {
    }

    public FirstDTO(First first) {
        this.name = first.getName();
        this.description = first.getDescription();
        this.updatedAt = first.getUpdated().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
