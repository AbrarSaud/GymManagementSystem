package com.example.capstone2.Repository;

import com.example.capstone2.Model.Booking;
import com.example.capstone2.Model.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking getBookingsById(Integer bookingId);


    @Query("select b from Booking b where b.userId =?1 and  b.gymClassId=?2")
    Booking getBookingByUserIdAndGymClassId(Integer userId, Integer gymClassId);

    //  Show the users  in the gym class
    @Query("select b.userId from Booking b WHERE b.gymClassId = :gymClassId")
    List<Integer> findUserIdsByGymClassId(Integer gymClassId);

    List<Booking> findByGymClassId(Integer gymClassId);

}
