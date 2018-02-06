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
@Table(name = "levels", schema = "my_schema")
public class Level implements Serializable {

    @Id
    @GenericGenerator(
            name = "data_db.levels_lv_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator"
    )
    @GeneratedValue(generator = "data_db.levels_lv_id_seq")
    @Column(name = "lv_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "lv_code", nullable = false, unique = true)
    private String code;

    @Column(name = "lv_process", nullable = false)
    private Integer process;

    @Column(name = "lv_description")
    private String description;

    @Column(name = "lv_created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "lv_created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Level() {
    }

    public Level(String code, Integer process, String description) {
        this.code = code;
        this.process = process;
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

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
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

        Level level = (Level) o;

        if (code != null ? !code.equals(level.code) : level.code != null) return false;
        return process != null ? process.equals(level.process) : level.process == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (process != null ? process.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", process=" + process +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", updatedAt=" + updatedAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
