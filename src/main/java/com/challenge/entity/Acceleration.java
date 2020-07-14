package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@EntityListeners({AuditingEntityListener.class,})
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column
    @Size(max = 100)
    private String name;

    @NotNull
    @Column
    @Size(max = 50)
    private String slug;

    @ManyToOne
    private Challenge challenge;

    @OneToMany(mappedBy = "acceleration_id")
    private List<Candidate> candidates;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;
}
