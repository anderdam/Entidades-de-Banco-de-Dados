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
@Table(name= "company")
@EntityListeners(AuditingEntityListener.class)
public class Company {

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

    public Company() {
    }

    public Company(int id, String name, String slug, Timestamp created_at) {
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

    public void setSlug(String sug) {
        this.slug = sug;
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
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return getId() == company.getId() &&
                Objects.equals(getName(), company.getName()) &&
                Objects.equals(getSlug(), company.getSlug()) &&
                Objects.equals(getCreated_at(), company.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSlug(), getCreated_at());
    }
}
