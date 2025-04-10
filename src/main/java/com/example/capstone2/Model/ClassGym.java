package com.example.capstone2.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ClassGym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ClassGymId;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "Name must not be Empty")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition = "varchar(25) not null")
    private LocalDateTime time;

    @NotNull(message = "The 'capacity' must be NOT Null")
    @Column(columnDefinition = "int not null")
    @Positive
    private Integer capacity;

    @NotNull(message = "The 'capacity' must be NOT Null")
    @Column(columnDefinition = "int not null")
    @Positive
    private Integer roomNum;

    @NotNull(message = "The 'Coach Id' must be NOT Null")
    @Column(columnDefinition = "int not null")
    private Integer coachId;
}


