package com.example.capstone2.Service;

import com.example.capstone2.Model.Coach;
import com.example.capstone2.Model.GymClass;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.GymClassRepository;
import com.example.capstone2.Repository.CoachRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GymClassService {
    private final UserRepository userRepository;
    private final GymClassRepository gymClassRepository;
    private final CoachRepository coachRepository;

    //     Get all ClassGym
    public List<GymClass> getAllClassGym() {
        return gymClassRepository.findAll();
    }

    //     Add a new GymClass
    public void addGymClass(GymClass gymClass) {
        User user = userRepository.findUserByUserId(gymClass.getUserId());
        Coach coach = coachRepository.findCoachByCoachId(gymClass.getCoachId());
        if (user != null || coach != null) {
            gymClassRepository.save(gymClass);
        }
    }

    //     Update a GymClass
    public Boolean updateGymClass(Integer gymClass_id, GymClass gymClass) {
        GymClass oldGymClass = gymClassRepository.findGymClassByGymClassId(gymClass_id);
        User user = userRepository.findUserByUserId(gymClass.getUserId());
        Coach coach = coachRepository.findCoachByCoachId(gymClass.getCoachId());
        if (oldGymClass == null || user == null || coach == null) {
            return false;
        }

        oldGymClass.setName(gymClass.getName());
        oldGymClass.setTime(gymClass.getTime());
        oldGymClass.setCapacity(gymClass.getCapacity());
        oldGymClass.setRoomNum(gymClass.getRoomNum());

        gymClassRepository.save(oldGymClass);
        return true;
    }

    //     Delete a GymClass
    public Boolean deleteGymClass(Integer gymClass_id) {
        GymClass deleteGymClass = gymClassRepository.findGymClassByGymClassId(gymClass_id);
        if (deleteGymClass == null) {
            return false;
        }
        gymClassRepository.delete(deleteGymClass);
        return true;
    }
}
