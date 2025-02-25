package com.enviro.assessment.inter001.axolemaranjana.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "waste_type")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class WasteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", unique = true)
    @NotNull(message = "'name' can not be null")
    @NotBlank(message = "'name' is mandatory")
    @Size(min = 2, max = 100, message = "'name' must be between 2 and 100 characters")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "wasteType")
    private Set<PickUp> pickUps;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdatedAt;

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
}
