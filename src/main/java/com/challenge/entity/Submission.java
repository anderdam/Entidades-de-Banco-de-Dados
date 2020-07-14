package com.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name= "submission")
@EntityListeners({AuditingEntityListener.class,})
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "challenge_id")
    private int challenge_id;
    @Column(name = "score")
    private float score;

    public Submission() {
    }

    public Submission(int user_id, int challenge_id, float score) {
        this.user_id = user_id;
        this.challenge_id = challenge_id;
        this.score = score;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Submission)) return false;
        Submission that = (Submission) o;
        return getUser_id() == that.getUser_id() &&
                getChallenge_id() == that.getChallenge_id() &&
                Float.compare(that.getScore(), getScore()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getChallenge_id(), getScore());
    }
}
