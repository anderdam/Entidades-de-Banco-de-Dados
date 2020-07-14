package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column
    @Size(max = 100)
    private String fullname;

    @NotNull
    @Column
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Column
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Column
    @Size(max = 255)
    private String password;


    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @OneToMany
    private List<Candidate> candidates;

    @OneToMany
    private List<Submission> submissions;
}
