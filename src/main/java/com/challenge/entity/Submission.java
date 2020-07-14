package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission {

    @EmbeddedId
    private IdSubmission id;

    @NotNull
    @Column
    private float score;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;
}
