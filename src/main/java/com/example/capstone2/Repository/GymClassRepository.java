package com.example.capstone2.Repository;

import com.example.capstone2.Model.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GymClassRepository extends JpaRepository<GymClass, Integer> {
    GymClass findGymClassByGymClassId(Integer gymClassId);

    @Query("update GymClass c set c.roomNum =?2 where c.gymClassId=?1")
    int updateRoomNumber(Integer classId, Integer newRoomNumber);


}
