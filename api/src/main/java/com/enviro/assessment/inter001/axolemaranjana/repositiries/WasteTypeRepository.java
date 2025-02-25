package com.enviro.assessment.inter001.axolemaranjana.repositiries;

import com.enviro.assessment.inter001.axolemaranjana.models.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteTypeRepository extends JpaRepository<WasteType, Long> {
}
