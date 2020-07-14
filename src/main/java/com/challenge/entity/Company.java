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

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name= "company")
@EntityListeners(AuditingEntityListener.class)
public class Company {

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
    @Size(max = 50)
    @Column(name = "slug")
    private String slug;
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany
    private List<Candidate> candidates;

    public Company() {
    }

    public Company(int id, String name, String slug, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.created_at = created_at;
    }
}
