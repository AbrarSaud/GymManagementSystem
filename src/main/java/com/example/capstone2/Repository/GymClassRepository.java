package com.example.capstone2.Repository;

import com.example.capstone2.Model.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GymClassRepository extends JpaRepository<GymClass, Integer> {
    // Find one gym class by gymClassId.
    GymClass findGymClassByGymClassId(Integer gymClassId);

    // Find one gym class by gymClassId and room number.
    GymClass findGymClassByGymClassIdAndRoomNum(Integer classId, Integer newRoomNumber);

}
