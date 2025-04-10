package com.example.capstone2.Repository;

import com.example.capstone2.Model.ClassGym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassGymRepository extends JpaRepository<ClassGym,Integer> {
    ClassGym findClassById(Integer gymId);
}
