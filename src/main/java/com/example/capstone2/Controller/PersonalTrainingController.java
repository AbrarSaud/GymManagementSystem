package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.PersonalTraining;
import com.example.capstone2.Service.PersonalTrainingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gym/personal-training")
@RequiredArgsConstructor
public class PersonalTrainingController {
    private final PersonalTrainingService personalTrainingService;

    //     Get all PersonalTraining
    @GetMapping("/get")
    public ResponseEntity<?> getAllPersonalTraining() {
        return ResponseEntity.ok(personalTrainingService.getAllPersonalTraining());
    }

    //     Add a new PersonalTraining
    @PostMapping("/add")
    public ResponseEntity<?> addPersonalTraining(@Valid @RequestBody PersonalTraining personalTraining, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        personalTrainingService.addPersonalTrainingPersonalTraining(personalTraining);
        return ResponseEntity.status(200).body(new ApiResponse("Personal PersonalTrainingTraining added !!"));
    }

    //     Update PersonalTraining
    @PutMapping("/update/{pt_id}")
    public ResponseEntity<?> updatePersonalTraining(@PathVariable Integer pt_id, @Valid @RequestBody PersonalTraining personalTraining, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = personalTrainingService.updatePersonalTraining(pt_id, personalTraining);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("PersonalTraining Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    //      Delete PersonalTraining
    @DeleteMapping("/delete/{pt_id}")
    public ResponseEntity<?> deletePersonalTraining(@PathVariable Integer pt_id) {
        Boolean isDelete = personalTrainingService.deletePersonalTraining(pt_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("PersonalTraining delete"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }
}
