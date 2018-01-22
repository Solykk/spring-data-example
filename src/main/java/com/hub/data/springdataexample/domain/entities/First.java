package com.hub.data.springdataexample.domain.entities;

import com.hub.data.springdataexample.utils.LocalDataTimeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Dmitriy Lyashenko
 */
@Entity
@Table(name = "first_table", schema = "my_schema")
public class First {

    @Id
    @GenericGenerator(
            name = "my_schema.first_table_ft_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "my_schema.first_table_ft_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_schema.first_table_ft_id_seq")
    @Column(name = "ft_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "ft_name", nullable = false, unique = true)
    private String name;

    @Column(name = "ft_description", nullable = false)
    private String description;

    @Column(name = "ft_created_at", nullable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "ft_updated_at", nullable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime updated = LocalDateTime.now();

    public First() {
    }

    public First(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "First{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}