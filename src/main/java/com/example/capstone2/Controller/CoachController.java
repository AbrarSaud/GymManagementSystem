package com.example.capstone2.Controller;


import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.Coach;
import com.example.capstone2.Service.CoachService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gym/coach")
@RequiredArgsConstructor
public class CoachController {
    private final CoachService coachService;


    //     Get all Coach
    @GetMapping("/get")
    public ResponseEntity<?> getAllCoach() {
        return ResponseEntity.ok(coachService.getAllCoach());
    }

    //     Add a new Coach
    @PostMapping("/add")
    public ResponseEntity<?> addCoach(@Valid @RequestBody Coach coach, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        coachService.addCoach(coach);
        return ResponseEntity.status(200).body(new ApiResponse("Coach added !!"));
    }

    //     Update Coach
    @PutMapping("/update/{coach_id}")
    public ResponseEntity<?> updateCoach(@PathVariable Integer coach_id, @Valid @RequestBody Coach coach, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = coachService.updateCoach(coach_id, coach);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("Coach Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    //      Delete Coach
    @DeleteMapping("/delete/{coach_id}")
    public ResponseEntity<?> deleteCoach(@PathVariable Integer coach_id) {
        Boolean isDelete = coachService.deleteCoach(coach_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("Coach delete"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    // best coaches
    @GetMapping("/top-coaches")
    public ResponseEntity<List<Coach>> getCoachesOrdered() {
        return ResponseEntity.ok(coachService.getAllCoachesOrderedByExperience());
    }


}
