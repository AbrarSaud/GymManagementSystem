package com.example.capstone2.Service;

import com.example.capstone2.Model.Coach;
import com.example.capstone2.Model.PersonalTraining;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.CoachRepository;
import com.example.capstone2.Repository.PersonalTrainingRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalTrainingService {
    private final PersonalTrainingRepository personalTrainingRepository;
    private final UserRepository userRepository;
    private final CoachRepository coachRepository;


    //     Get all PersonalTraining
    public List<PersonalTraining> getAllPersonalTraining() {
        return personalTrainingRepository.findAll();
    }

    //     Add a new PersonalTraining
    public void addPersonalTrainingPersonalTraining(PersonalTraining personalTraining) {
        User user = userRepository.findUserByUserId((personalTraining.getUserId()));
        Coach coach = coachRepository.findCoachByCoachId(personalTraining.getCoachId());
        if (user != null && coach != null) {
            personalTrainingRepository.save(personalTraining);
        }

    }

    //     Update a PersonalTraining
    public Boolean updatePersonalTraining(Integer pt_id, PersonalTraining personalTraining) {
        PersonalTraining oldPersonalTraining = personalTrainingRepository.findPersonalTrainingByPersonalTrainingId(pt_id);
        User user = userRepository.findUserByUserId((personalTraining.getUserId()));
        Coach coach = coachRepository.findCoachByCoachId(personalTraining.getCoachId());
        if (oldPersonalTraining == null && user != null && coach != null) {
            return false;
        }
        oldPersonalTraining.setStartDate(personalTraining.getStartDate());
        oldPersonalTraining.setSubscriptionMonths(personalTraining.getSubscriptionMonths());
        oldPersonalTraining.setPrice((personalTraining.getPrice()));

        personalTrainingRepository.save(oldPersonalTraining);
        return true;
    }

    //     Delete a PersonalTraining
    public Boolean deletePersonalTraining(Integer pt_id) {
        PersonalTraining deletePersonalTraining = personalTrainingRepository.findPersonalTrainingByPersonalTrainingId(pt_id);
        if (deletePersonalTraining == null) {
            return false;
        }
        personalTrainingRepository.delete(deletePersonalTraining);
        return true;
    }

}
