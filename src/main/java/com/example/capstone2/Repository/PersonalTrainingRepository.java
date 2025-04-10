package com.example.capstone2.Repository;

import com.example.capstone2.Model.PersonalTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainingRepository extends JpaRepository<PersonalTraining, Integer> {
    PersonalTraining findPersonalTrainingById(Integer personalTrainingId);
}
