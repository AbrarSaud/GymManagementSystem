package com.example.capstone2.Repository;

import com.example.capstone2.Model.Coach;
import com.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {
    Coach findCoachByCoachId(Integer coachId);

    // Show the best coaches
    @Query("select c from Coach c order by  c.yearsOfExperience desc ")
    List<Coach> getAllCoachesOrderByYearsOfExperienceDesc();

}
