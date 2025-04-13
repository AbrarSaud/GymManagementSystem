package com.example.capstone2.Repository;

import com.example.capstone2.Model.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GymClassRepository extends JpaRepository<GymClass, Integer> {
    GymClass findGymClassByGymClassId(Integer gymClassId);

    GymClass findGymClassByGymClassIdAndRoomNum(Integer classId, Integer newRoomNumber);



}
