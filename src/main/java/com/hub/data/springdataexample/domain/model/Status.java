package com.hub.data.springdataexample.domain.model;

import com.hub.data.springdataexample.utils.LocalDataTimeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Dmitriy Lyashenko
 */
@Entity
@Table(name = "statuses", schema = "my_schema")
public class Status implements Serializable {

    @Id
    @GenericGenerator(
            name = "data_db.statuses_st_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator"
    )
    @GeneratedValue(generator = "data_db.statuses_st_id_seq")
    @Column(name = "st_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "st_code", nullable = false, unique = true)
    private String code;

    @Column(name = "st_description")
    private String description;

    @Column(name = "st_created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "st_created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Status() {
    }

    public Status(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        return code != null ? code.equals(status.code) : status.code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", updatedAt=" + updatedAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
