package com.example.capstone2.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class PersonalTrainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer coachId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate startData;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate endDate;

    @Column(columnDefinition = "int not null")
    @Positive(message = "Price must be positive")
    private Integer price;

    private  String bmi;
//    Less than 18.5: underweight
//18.5 to 24.9: normal weight
//25 to 29.9: overweight
//30 or higher: obese






}


