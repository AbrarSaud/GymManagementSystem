package com.example.capstone2.Repository;

import com.example.capstone2.Model.Coach;
import com.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository  extends JpaRepository<Coach,Integer> {
    Coach findCoachByCoachId(Integer coachId);


}
