package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_acceleration")
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @Size(max = 100)
    private String name;
    @Column(name = "slug")
    @Size(max = 50)
    private String slug;
    @Column(name = "chalenge_id")
    private int challenge_id;
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;


    public Acceleration() {}

    public Acceleration(int id, String name, String slug, int challenge_id, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.challenge_id = challenge_id;
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

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acceleration)) return false;
        Acceleration that = (Acceleration) o;
        return getId() == that.getId() &&
                getChallenge_id() == that.getChallenge_id() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSlug(), that.getSlug()) &&
                Objects.equals(getCreated_at(), that.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSlug(), getChallenge_id(), getCreated_at());
    }
    
}
