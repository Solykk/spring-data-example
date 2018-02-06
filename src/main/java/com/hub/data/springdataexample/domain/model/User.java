package com.hub.data.springdataexample.domain.model;

import com.hub.data.springdataexample.utils.LocalDataTimeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Dmitriy Lyashenko
 */
@Entity
@Table(name = "users", schema = "my_schema")
public class User implements Serializable {

    @Id
    @GenericGenerator(
            name = "data_db.users_u_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator"
    )
    @GeneratedValue(generator = "data_db.users_u_id_seq")
    @Column(name = "u_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_email", nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "u_status_id", referencedColumnName = "st_id")
    private Status status;

    @ManyToMany
    @JoinTable(name = "friends", schema = "my_schema", joinColumns = {
            @JoinColumn(name = "u_p_id", referencedColumnName = "u_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "u_f_id", referencedColumnName = "u_id")
    })
    private Set<User> friends;

    @Column(name = "u_is_enabled")
    private boolean isEnabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "additional_information_id", referencedColumnName = "ai_id")
    private AdditionalInformation additionalInformation;

    @ManyToMany
    @JoinTable(name = "users_areas", schema = "my_schema",
            joinColumns = {@JoinColumn(name = "u_id", referencedColumnName = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "ar_id", referencedColumnName = "ar_id")
    })
    private Set<Area> areas;

    @OneToMany
    @JoinColumn(name = "u_post_id")
    private List<Post> posts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "u_level_id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "u_credentials_id")
    private Credentials credentials;

    @Column(name = "u_created_at", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "u_updatedAt", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDataTimeConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static UserBuilder builder(User user){
        return new UserBuilder(user);
    }

    public static class UserBuilder {

        private User instance;

        private UserBuilder(){instance = new User();}

        private UserBuilder(User user){instance = user;}

        public UserBuilder name(String name){
            instance.setName(name);
            return this;
        }

        public UserBuilder email(String email){
            instance.setEmail(email);
            return this;
        }

        public UserBuilder status(Status status){
            instance.setStatus(status);
            return this;
        }

        public UserBuilder friends(Set<User> friends){
            instance.setFriends(friends);
            return this;
        }

        public UserBuilder isEnabled(boolean isEnabled){
            instance.setEnabled(isEnabled);
            return this;
        }

        public UserBuilder additionalInformation(AdditionalInformation additionalInformation){
            instance.setAdditionalInformation(additionalInformation);
            return this;
        }

        public UserBuilder areas(Set<Area> areas){
            instance.setAreas(areas);
            return this;
        }

        public UserBuilder level(Level level){
            instance.setLevel(level);
            return this;
        }

        public UserBuilder credentials(Credentials credentials){
            instance.setCredentials(credentials);
            return this;
        }

        public UserBuilder updatedAt(LocalDateTime updatedAt){
            instance.setUpdatedAt(updatedAt);
            return this;
        }

        public User getInstance() {
            return instance;
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(AdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
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

        User user = (User) o;

        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", friends=" + friends.stream().map(user -> name) +
                ", isEnabled=" + isEnabled +
                ", additionalInformation=" + additionalInformation +
                ", areas=" + areas +
                ", posts=" + posts +
                ", level=" + level +
                ", credentials=" + credentials +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", updatedAt=" + updatedAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
