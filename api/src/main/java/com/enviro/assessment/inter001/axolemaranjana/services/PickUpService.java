package com.enviro.assessment.inter001.axolemaranjana.services;

import com.enviro.assessment.inter001.axolemaranjana.models.PickUp;
import com.enviro.assessment.inter001.axolemaranjana.models.WasteType;
import com.enviro.assessment.inter001.axolemaranjana.repositiries.PickUpRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickUpService {
    @Autowired
    PickUpRepository pickUpRepository;

    @Autowired
    WasteTypeService wasteTypeService;

    public List<PickUp> getAllPickUps() {
        return pickUpRepository.findAll();
    }

    public PickUp createNew(@Valid PickUp pickUp) {

        WasteType waste = wasteTypeService.getById(pickUp.getWasteType().getId());

        pickUp.setWasteType(waste);

        return pickUpRepository.save(pickUp);
    }
}
