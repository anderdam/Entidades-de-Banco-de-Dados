package com.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "user")
@EntityListeners({AuditingEntityListener.class,})
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;
    @Column(name = "full_name")
    @Max(100)
    private String full_name;
    @Column(name = "email")
    @Email
    @Max(100)
    private String email;
    @Column(name = "nickname")
    @Max(50)
    private String nickname;
    @Column(name = "password")
    @Max(255)
    private String password;
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    public User() {
    }

    public User(int id, String full_name, String email, String nickname, String password, Timestamp created_at) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getFull_name(), user.getFull_name()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getNickname(), user.getNickname()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getCreated_at(), user.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFull_name(), getEmail(), getNickname(), getPassword(), getCreated_at());
    }
}
