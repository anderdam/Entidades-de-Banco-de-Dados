package com.challenge.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name= "tb_challenge")
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name")
    @Size(max = 100)
    private String name;

    @NotNull
    @Column(name = "slug")
    @Size(max = 50)
    private String slug;
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany
    private List<Acceleration> accelerations;

    @OneToMany
    private List<Submission> submissions;

    public Challenge() {
    }

    public Challenge(int id, String name, String slug, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.created_at = created_at;
    }
}
