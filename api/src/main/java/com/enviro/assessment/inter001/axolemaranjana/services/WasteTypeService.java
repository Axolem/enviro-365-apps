package com.enviro.assessment.inter001.axolemaranjana.services;

import com.enviro.assessment.inter001.axolemaranjana.models.WasteType;
import com.enviro.assessment.inter001.axolemaranjana.repositiries.WasteTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteTypeService {
    @Autowired
    WasteTypeRepository wasteTypeRepository;

    public WasteType getById(Long id) {
        return wasteTypeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find waste category with id: " + id)
        );
    }

    public List<WasteType> getAllWasteTypes() {
        return wasteTypeRepository.findAll();
    }

    public WasteType createNew(WasteType wasteType) {

        return wasteTypeRepository.save(wasteType);
    }
}
