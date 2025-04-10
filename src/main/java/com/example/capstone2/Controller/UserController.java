package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.User;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/blog/users")
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
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added !!"));
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
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    //      Delete User
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer user_id) {
        Boolean isDelete = userService.deleteUser(user_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("User delete"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }
}
