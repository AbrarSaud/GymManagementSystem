package com.example.capstone2.Repository;

import com.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserId(Integer userId);


    //Show a list of users bmi >= 25
    @Query("select u from User u where u.bmi >= 25")
    List<User> getUsersWithBmiGreater();

    //Show a list of New users
    @Query("select u from User u where u.startData  >= ?1")
    List<User> findNewUsers(LocalDate today);


}
