package com.example.capstone2.Service;

import com.example.capstone2.Model.Booking;
import com.example.capstone2.Model.GymClass;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.BookingRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Add new booking
    public void addBooking(Booking booking) {
        Booking booking1 = bookingRepository.getBookingsById(booking.getId());
        User user = userRepository.findUserByUserId(booking.getUserId());
        if (booking1 != null && user != null) {
            bookingRepository.save(booking);
        }
    }

    // Delete booking
    public Boolean deleteBooking(Integer bookingId) {
        Booking booking = bookingRepository.getBookingsById(bookingId);
        if (booking == null) {
            return false;
        }
        bookingRepository.delete(booking);
        return true;
    }

    //  Show the users in the gym class
    public List<Booking> getBookingByUserId(Integer userId, Integer gymClassId) {
        return bookingRepository.getBookingByUserIdAndGymClassId(userId, gymClassId);
    }

    public List<String> getUsernamesInGymClass(Integer gymClassId) {
        List<Integer> userIds = bookingRepository.findUserIdsByGymClassId(gymClassId);
        if (userIds == null) {
            return null;
        }
        return userRepository.findUsernamesByIds(userIds);
    }
}
