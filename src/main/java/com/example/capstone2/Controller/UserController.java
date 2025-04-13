package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.User;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/gym/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //     Get all Users
    @GetMapping("/get")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //     Add a new User
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isAdded = userService.addUser(user);
        if (!isAdded) {
            return ResponseEntity.status(404).body(new ApiResponse("User could not be added!"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully!"));
    }

    //     Update User
    @PutMapping("/update/{user_id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer user_id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = userService.updateUser(user_id, user);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("User Update"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Not found"));
    }

    //      Delete User
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer user_id) {
        Boolean isDelete = userService.deleteUser(user_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("User delete"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Not found"));
    }

    //   (Endpoints # 1)  Get all users where BMI is bigger than or equal to 25.
    @GetMapping("/high-bmi")
    public ResponseEntity<?> getUsersWithBmi() {
        return ResponseEntity.ok(userService.getUsersWithBmi());
    }

    //  (Endpoints # 2)   Show a list of new users in the last 7 days.( calculate the date 7 days )
    @GetMapping("/new")
    public ResponseEntity<?> getNewUsersToday() {
        return ResponseEntity.ok(userService.getNewUsers());
    }

//    (Endpoints # 3 ) calculate his BMI from weight and height by user ID.
//    Then save the new BMI and category in database.
    @PutMapping("/calculate-bmi/{user_id}")
    private ResponseEntity<?> calculateBmi(@PathVariable Integer user_id) {
        String message = userService.calculateBmi(user_id);
        if (message.contains("not found")) {
            return ResponseEntity.status(404).body(new ApiResponse(message));
        }
        return ResponseEntity.ok(new ApiResponse(message));
    }
}
