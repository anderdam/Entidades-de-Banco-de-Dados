package com.challenge.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_user")
@EntityListeners({AuditingEntityListener.class,})
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "fullname")
    @Size(max = 100)
    private String full_name;

    @NotNull
    @Column(name = "email")
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Column(name = "nickname")
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Column(name = "password")
    @Size(max = 255)
    private String password;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany
    private List<Candidate> candidates;

    @OneToMany
    private List<Submission> submissions;


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
}
