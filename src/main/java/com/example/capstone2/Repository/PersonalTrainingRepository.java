package com.example.capstone2.Repository;

import com.example.capstone2.Model.PersonalTraining;
import com.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainingRepository extends JpaRepository<PersonalTraining, Integer> {
    PersonalTraining findPersonalTrainingByPersonalTrainingId(Integer personalTrainingId);

//    // Calculate the user's BMI from their weight and height.
//    User findUserByWeightAndHeight(Integer weight, Integer height);

}
