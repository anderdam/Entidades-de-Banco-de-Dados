package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@EntityListeners({AuditingEntityListener.class})
@Embeddable
public class Candidate {

    @EmbeddedId
    private IdCandidate id;

    @NotNull
    @Column
    private int status;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;
}