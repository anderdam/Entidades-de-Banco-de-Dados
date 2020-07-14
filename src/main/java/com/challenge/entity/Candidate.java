package com.challenge.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name= "tb_candidate")
@EntityListeners({AuditingEntityListener.class})
@Embeddable
public class Candidate {

    @EmbeddedId
    @Column(name = "user_id")
    private User user_id;

    @JoinColumn(name = "id")
    @Column(name = "acceleration_id")
    private Acceleration acceleration_id;

    @JoinColumn(name = "id")
    @Column(name = "company_id")
    private Company company_id;

    @NotNull
    @Column(name = "status")
    private int status;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    public Candidate() {
    }

    public Candidate(User user_id, Acceleration acceleration_id, Company company_id, int status, Timestamp created_at) {
        this.user_id = user_id;
        this.acceleration_id = acceleration_id;
        this.company_id = company_id;
        this.status = status;
        this.created_at = created_at;
    }
}