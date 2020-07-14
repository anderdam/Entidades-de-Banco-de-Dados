package com.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name= "tb_challenge")
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "slug")
    private String slug;
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    public Challenge() {
    }

    public Challenge(int id, String name, String slug, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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
        if (!(o instanceof Challenge)) return false;
        Challenge challenge = (Challenge) o;
        return getId() == challenge.getId() &&
                Objects.equals(getName(), challenge.getName()) &&
                Objects.equals(getSlug(), challenge.getSlug()) &&
                Objects.equals(getCreated_at(), challenge.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSlug(), getCreated_at());
    }
}
