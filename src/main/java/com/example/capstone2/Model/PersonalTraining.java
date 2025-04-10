package com.example.capstone2.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class PersonalTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "The user id must not be empty")
    private Integer userId;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "The coach id must not be empty")
    private Integer coachId;

    @Column(columnDefinition = "date not null")
    @NotNull(message = "The start date must not be empty")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "The subscription months must not be empty")
    @Positive(message = "Subscription months must be positive")
    private Integer subscriptionMonths;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "The price must not be empty")
    @Positive(message = "Price must be positive")
    private Integer price;

}


