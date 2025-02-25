package com.enviro.assessment.inter001.axolemaranjana.controllers;

import com.enviro.assessment.inter001.axolemaranjana.models.PickUp;
import com.enviro.assessment.inter001.axolemaranjana.responses.ResponseBuilder;
import com.enviro.assessment.inter001.axolemaranjana.services.PickUpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/pick-up")
public class PickUpController {
    @Autowired
    PickUpService pickUpService;
    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<PickUp> pickUps = pickUpService.getAllPickUps(); // Assuming this returns a List
            if (pickUps == null || pickUps.isEmpty()) {
                return responseBuilder.buildErrorResponse("No pick ups found", HttpStatus.OK);
            }
            return responseBuilder.buildSuccessResponse("Pick ups retrieved successfully", pickUps, pickUps.size(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return responseBuilder.buildErrorResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody PickUp pickUp) {
        try {
            PickUp newPickUp = pickUpService.createNew(pickUp);
            if (newPickUp == null) {
                return responseBuilder.buildErrorResponse("Failed to create pick up", HttpStatus.BAD_REQUEST);
            }

            return responseBuilder.buildSuccessResponse("Created a new pick up successfully", newPickUp, 1, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return responseBuilder.buildErrorResponse("Failed creating new pick up", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
