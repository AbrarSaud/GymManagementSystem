package com.example.capstone2.Service;

import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.ClassGymRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ClassGymRepository classGymRepository;

    //     Get all Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //     Add a new User
    public void addUser(User user) {

            userRepository.save(user);

    }

    //     Update a User
    public Boolean updateUser(Integer user_id, User user) {
        User oldUser = userRepository.findUserById(user_id);
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
