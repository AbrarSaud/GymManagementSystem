package com.example.capstone2.Service;

import com.example.capstone2.Model.Coach;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachService {
    private final CoachRepository coachRepository;


    //     Get all Coach
    public List<Coach> getAllCoach() {
        return coachRepository.findAll();
    }

    //     Add a new Coach
    public void addCoach(Coach coach) {
        coachRepository.save(coach);
    }

    //     Update a Coach
    public Boolean updateCoach(Integer coach_id, Coach coach) {
        Coach oldCoach = coachRepository.findCoachByCoachId(coach_id);
        if (oldCoach == null) {
            return false;
        }
        oldCoach.setName(coach.getName());
        if (coach.getEmail() != null) {
            oldCoach.setEmail(coach.getEmail());
        }
        oldCoach.setPassword(coach.getPassword());

        oldCoach.setYearsOfExperience(coach.getYearsOfExperience());
        coachRepository.save(oldCoach);
        return true;
    }

    //     Delete a Coach
    public Boolean deleteCoach(Integer coach_id) {
        Coach deleteCoach = coachRepository.findCoachByCoachId(coach_id);
        if (deleteCoach == null) {
            return false;
        }
        coachRepository.delete(deleteCoach);
        return true;
    }
}
