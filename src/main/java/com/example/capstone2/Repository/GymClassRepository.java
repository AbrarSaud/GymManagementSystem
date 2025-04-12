package com.example.capstone2.Repository;

import com.example.capstone2.Model.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymClassRepository extends JpaRepository<GymClass, Integer> {
    GymClass findGymClassByGymClassId(Integer gymClassId);

//    // Reserve  in the class based (capacity)
//    @Query("select g from GymClass g where g.userId =?1 and g.gymClassId =?2")
//    GymClass findGymClassByUserIdAndGymClassId( Integer userId,Integer gymClassId);


}
