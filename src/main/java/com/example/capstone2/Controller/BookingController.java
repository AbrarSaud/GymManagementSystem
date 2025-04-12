package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.Booking;
import com.example.capstone2.Service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gym/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // Get all bookings
    @GetMapping("/get")
    public ResponseEntity<?> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // Add new booking
    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@Valid @RequestBody Booking booking, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        bookingService.addBooking(booking);
        return ResponseEntity.status(200).body(new ApiResponse("Booking added !"));
    }

    // Delete booking
    @DeleteMapping("/delete/{booking_id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Integer booking_id) {
        Boolean isDeleted = bookingService.deleteBooking(booking_id);
        if (!isDeleted) {
            return ResponseEntity.status(404).body(new ApiResponse("Booking not found!"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Booking deleted !"));
    }


    @GetMapping("/class/{gymClassId}")
    public ResponseEntity<List<String>> getUsernamesInClass(@PathVariable Integer gymClassId) {
        List<String> usernames = bookingService.getUsernamesInGymClass(gymClassId);
        return ResponseEntity.ok(usernames);
    }

    @PutMapping("/change/{userId}/{oldGymClassId}/{newGymClassId}")
    public ResponseEntity<?> changeUserGymClass(@PathVariable Integer userId, @PathVariable Integer oldGymClassId, @PathVariable Integer newGymClassId) {
        Boolean isChanged = bookingService.changeUserGymClass(userId, oldGymClassId, newGymClassId);
        if (!isChanged) {
            return ResponseEntity.status(404).body(new ApiResponse("Failed to change gym class!"));
        }
        return ResponseEntity.ok(new ApiResponse("Successfully changed gym class!"));
    }


}
