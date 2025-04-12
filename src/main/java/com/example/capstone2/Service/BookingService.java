package com.example.capstone2.Service;

import com.example.capstone2.Model.Booking;
import com.example.capstone2.Model.Coach;
import com.example.capstone2.Model.GymClass;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.BookingRepository;
import com.example.capstone2.Repository.GymClassRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final GymClassRepository gymClassRepository;

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Add new booking
    public void addBooking(Booking booking) {
        User existingUser = userRepository.findUserByUserId(booking.getUserId());
        GymClass checkCapacity = gymClassRepository.findGymClassByGymClassId(booking.getGymClassId());

        if (existingUser != null && checkCapacity != null && checkCapacity.getCapacity() > 0) {
            checkCapacity.setCapacity(checkCapacity.getCapacity() - 1);
            gymClassRepository.save(checkCapacity);
            bookingRepository.save(booking);
        }
    }

    // Delete booking
    public Boolean deleteBooking(Integer bookingId) {
        Booking existingBooking = bookingRepository.getBookingsById(bookingId);
        if (existingBooking == null) {
            return false;
        }
        GymClass existingGymClass = gymClassRepository.findGymClassByGymClassId(existingBooking.getGymClassId());
        if (existingGymClass != null) {
            existingGymClass.setCapacity(existingGymClass.getCapacity() + 1);
            gymClassRepository.save(existingGymClass);
        }
        bookingRepository.delete(existingBooking);
        return true;
    }

    public List<String> getUsernamesInGymClass(Integer gymClassId) {
        List<Integer> userIds = bookingRepository.findUserIdsByGymClassId(gymClassId);
        if (userIds == null) {
            return null;
        }
        return userRepository.findUsernamesByIds(userIds);
    }

    //  change  GymClass
    public Boolean changeUserGymClass(Integer userId, Integer oldGymClassId, Integer newGymClassId) {
        Booking existingBooking = bookingRepository.getBookingByUserIdAndGymClassId(userId, oldGymClassId);
        if (existingBooking == null) {
            return false;
        }
        GymClass oldGymClass = gymClassRepository.findGymClassByGymClassId(oldGymClassId);
        GymClass newGymClass = gymClassRepository.findGymClassByGymClassId(newGymClassId);

        if (newGymClass == null || newGymClass.getCapacity() > 20) {
            return false;
        }
        if (oldGymClass == null) {
            oldGymClass.setCapacity(oldGymClass.getCapacity() + 1);
            gymClassRepository.save(oldGymClass);
        }
        newGymClass.setCapacity(newGymClass.getCapacity() - 1);
        gymClassRepository.save(newGymClass);
        existingBooking.setGymClassId(newGymClassId);
        bookingRepository.save(existingBooking);
        return true;
    }



}
