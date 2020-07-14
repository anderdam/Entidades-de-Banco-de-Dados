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
@Table(name= "tb_candidate")
@EntityListeners({AuditingEntityListener.class})
public class Candidate {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "acceleration_id")
    private int acceleration_id;
    @Column(name = "company_id")
    private int company_id;
    @Column(name = "status")
    private int status;
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    public Candidate() {
    }

    public Candidate(int user_id, int acceleration_id, int company_id, int status, Timestamp created_at) {
        this.user_id = user_id;
        this.acceleration_id = acceleration_id;
        this.company_id = company_id;
        this.status = status;
        this.created_at = created_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAcceleration_id() {
        return acceleration_id;
    }

    public void setAcceleration_id(int acceleration_id) {
        this.acceleration_id = acceleration_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(o instanceof Candidate)) return false;
        Candidate candidate = (Candidate) o;
        return getUser_id() == candidate.getUser_id() &&
                getAcceleration_id() == candidate.getAcceleration_id() &&
                getCompany_id() == candidate.getCompany_id() &&
                getStatus() == candidate.getStatus() &&
                Objects.equals(getCreated_at(), candidate.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getAcceleration_id(), getCompany_id(), getStatus(), getCreated_at());
    }

}
