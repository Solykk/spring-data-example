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
@Table(name = "posts", schema = "my_schema")
public class Post implements Serializable{

    @Id
    @GenericGenerator(
            name = "data_db.posts_p_id_seq",
            strategy = "org.hibernate.id.UUIDHexGenerator"
    )
    @GeneratedValue(generator = "data_db.posts_p_id_seq")
    @Column(name = "p_uuid", nullable = false, unique = true, columnDefinition = "VARCHAR(32)")
    private String uuid;

    @Column(name = "p_message", nullable = false)
    private String message;

    @Column(name = "p_created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "p_updatedAt", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Post() {
    }

    public Post(String message) {
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

        Post post = (Post) o;

        return message != null ? message.equals(post.message) : post.message == null;
    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Post{" +
                "uuid='" + uuid + '\'' +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", updatedAt=" + updatedAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
