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
@Table(name = "additional_information", schema = "my_schema")
public class AdditionalInformation implements Serializable {

    @Id
    @GenericGenerator(
            name = "data_db.additional_information_ai_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator"
    )
    @GeneratedValue(generator = "data_db.additional_information_ai_id_seq")
    @Column(name = "ai_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "ai_description")
    private String description;

    @Column(name = "ai_address")
    private String address;

    @Column(name = "ai_age")
    private Integer age;

    /**
     * sex attribute: true -> man | false -> woman
     */
    @Column(name = "ai_sex")
    private boolean sex;

    @Column(name = "ai_created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "ai_created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public AdditionalInformation() {
    }

    public AdditionalInformation(String description, String address, Integer age, boolean sex) {
        this.description = description;
        this.address = address;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
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
    public String toString() {
        return "AdditionalInformation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", updatedAt=" + updatedAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
