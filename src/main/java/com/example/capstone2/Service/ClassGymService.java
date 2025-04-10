package com.example.capstone2.Service;

import com.example.capstone2.Model.Coach;
import com.example.capstone2.Model.GymClass;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.ClassGymRepository;
import com.example.capstone2.Repository.CoachRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassGymService {
    private final UserRepository userRepository;
    private final ClassGymRepository classGymRepository;
    private final CoachRepository coachRepository;

    //     Get all ClassGym
    public List<GymClass> getAllClassGym() {
        return classGymRepository.findAll();
    }

    //     Add a new ClassGym
    public void addClassGym(GymClass classGym) {
        User oldUser = userRepository.findUserById(classGym.getUserId());
        classGymRepository.save(classGym);

    }

    //     Update a ClassGym
    public Boolean updateUser(Integer classGym_id, GymClass classGym) {
        User User = userRepository.findUserById(classGym.getUserId());
        GymClass OldClass =classGymRepository.findClassById(classGym_id);
        Coach coach =coachRepository.findCoachById(classGym.getCoachId())
        if (oldUser == null) {
            return false;
        }
        oldUser.setName(user.getName());
        if (user.getUserName() != null) {
            oldUser.setUserName(user.getUserName());
        }
        oldUser.setPassword(user.getPassword());
        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        oldUser.setAge(user.getAge());
        oldUser.setWeight(user.getWeight());
        oldUser.setHeight(user.getHeight());
        oldUser.setStartData(user.getStartData());
        userRepository.save(oldUser);
        return true;
    }

    //     Delete a User
    public Boolean deleteUser(Integer user_id) {
        User userToDelete = userRepository.findUserById(user_id);
        if (userToDelete == null) {
            return false;
        }
        userRepository.delete(userToDelete);
        return true;
    }
}
