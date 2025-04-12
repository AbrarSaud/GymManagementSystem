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
    public ResponseEntity<?> addPersonalTraining(@RequestBody @Valid PersonalTraining personalTraining, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isAdded = personalTrainingService.addPersonalTrainingPersonalTraining(personalTraining);
        if (!isAdded) {
            return ResponseEntity.status(404)
                    .body(new ApiResponse("User or Coach not found"));
        }
        return ResponseEntity.ok(new ApiResponse("PersonalTraining added !"));
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
        return ResponseEntity.status(404).body(new ApiResponse("Not found"));
    }

    //      Delete PersonalTraining
    @DeleteMapping("/delete/{pt_id}")
    public ResponseEntity<?> deletePersonalTraining(@PathVariable Integer pt_id) {
        Boolean isDelete = personalTrainingService.deletePersonalTraining(pt_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("PersonalTraining delete"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Not found"));
    }

    //Subscription Info
    @GetMapping("/subscription-info/{personalTrainingId}")
    public ResponseEntity<?> getSubscriptionInfo(@PathVariable Integer personalTrainingId) {
        String info = personalTrainingService.getSubscriptionInfo(personalTrainingId);

        if (info == null) {
            return ResponseEntity.status(404).body(new ApiResponse("Personal training not found"));
        }

        return ResponseEntity.ok(new ApiResponse(info));
    }

    @PostMapping("/renew/{pt_id}/{months}")
    public ResponseEntity<?> renewSubscription(@PathVariable Integer pt_id, @PathVariable Integer months) {
        String response = personalTrainingService.renewSubscription(pt_id, months);

        if (response.contains("not found") || response.contains("only renew")) {
            return ResponseEntity.badRequest().body(new ApiResponse(response));
        }

        return ResponseEntity.ok(new ApiResponse(response));
    }

    @PostMapping("/discount")
    public ResponseEntity<?> applyDiscount(@RequestParam Integer personalTrainingId, @RequestParam Double discountPercentage) {
        return ResponseEntity.ok(new ApiResponse("Discount applied successfully. New price: " + personalTrainingService.applyDiscount(personalTrainingId, discountPercentage)));
    }

    @PostMapping("/freeze/{pt_id}")
    public ResponseEntity<?> freezeSubscription(@PathVariable Integer pt_id) {
        String response = personalTrainingService.freezeSubscription(pt_id);

        if (response.contains("not found")) {
            return ResponseEntity.status(404).body(new ApiResponse(response));
        }

        return ResponseEntity.ok(new ApiResponse(response));
    }

    @PutMapping("/change-coach/{ptId}/{oldCoachId}/{newCoachId}")
    public ResponseEntity<?> changeCoach(@PathVariable Integer ptId, @PathVariable Integer oldCoachId, @PathVariable Integer newCoachId) {
        boolean isChanged = personalTrainingService.changeCoach(ptId, oldCoachId, newCoachId);

        if (!isChanged) {
            return ResponseEntity.status(404).body(new ApiResponse("PersonalTraining or Coach not found"));
        }

        return ResponseEntity.ok(new ApiResponse("Coach changed !"));
    }

    @PutMapping("/extend-freeze/{pt_Id}")
    public ResponseEntity<String> extendFreeze(@PathVariable Integer pt_Id, @RequestParam Integer extraDays) {
        String message = personalTrainingService.extendFreeze(pt_Id, extraDays);
        return ResponseEntity.ok(message);
    }

}
