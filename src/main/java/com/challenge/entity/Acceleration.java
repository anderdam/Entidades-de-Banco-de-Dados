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
@Table(name = "tb_acceleration")
@Entity
@EntityListeners({AuditingEntityListener.class,})
public class Acceleration {

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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "challenge_id")
    private Challenge challenge_id;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany
    private List<Candidate> candidates;


    public Acceleration() {}

    public Acceleration(int id, String name, String slug, Challenge challenge_id, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.challenge_id = challenge_id;
        this.created_at = created_at;
    }
}
