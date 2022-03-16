package com.web.restful.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worker_sequence")
    @SequenceGenerator(name = "worker_sequence", sequenceName = "worker_sequence", allocationSize = 1)
    private Long workerId;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birth;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

}
