package com.example.capstone2.Repository;

import com.example.capstone2.Model.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassGymRepository extends JpaRepository<GymClass,Integer> {
    GymClass findClassById(Integer gymId);
}
