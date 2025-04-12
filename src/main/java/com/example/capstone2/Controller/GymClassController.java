package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.GymClass;
import com.example.capstone2.Model.User;
import com.example.capstone2.Service.GymClassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gym/gym-class")
@RequiredArgsConstructor
public class GymClassController {
    private final GymClassService gymClassService;

    //     Get all GymClass
    @GetMapping("/get")
    public ResponseEntity<?> getAllGymClass() {
        return ResponseEntity.ok(gymClassService.getAllClassGym());
    }

    //     Add a new GymClass
    @PostMapping("/add")
    public ResponseEntity<?> addGymClass(@Valid @RequestBody GymClass gymClass, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isAdded = gymClassService.addGymClass(gymClass);

        if (!isAdded) {
            return ResponseEntity.status(404).body(new ApiResponse("Coach not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("GymClass added !!"));
    }

    //     Update GymClass
    @PutMapping("/update/{gymClass_id}")
    public ResponseEntity<?> updateGymClass(@PathVariable Integer gymClass_id, @Valid @RequestBody GymClass gymClass, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = gymClassService.updateGymClass(gymClass_id, gymClass);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("GymClass Update"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Not found"));
    }

    //      Delete GymClass
    @DeleteMapping("/delete/{gymClass_id}")
    public ResponseEntity<?> deleteGymClass(@PathVariable Integer gymClass_id) {
        Boolean isDelete = gymClassService.deleteGymClass(gymClass_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("GymClass delete"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Not found"));
    }





}
