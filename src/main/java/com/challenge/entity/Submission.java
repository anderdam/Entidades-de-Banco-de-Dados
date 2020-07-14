package com.challenge.entity;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
@Entity
@Table(name= "submission")
@EntityListeners({AuditingEntityListener.class,})
@Embeddable
public class Submission {

    @EmbeddedId
    @Column(name = "user_id")
    private User user_id;

    @JoinColumn(name = "id")
    @Column(name = "challenge_id")
    private Challenge challenge_id;

    @NotNull
    @Column(name = "score")
    private float score;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    public Submission() {
    }

    public Submission(User user_id, Challenge challenge_id, float score) {
        this.user_id = user_id;
        this.challenge_id = challenge_id;
        this.score = score;
    }
}
