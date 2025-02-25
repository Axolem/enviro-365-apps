package com.enviro.assessment.inter001.axolemaranjana.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "pick_up")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PickUp {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(columnDefinition = "DATE")
    @NonNull
    @NotNull
    private LocalDate date;

    @Column(columnDefinition = "TIME")
    @NonNull
    @NotNull
    private LocalTime time;

    @NonNull
    @NotNull
    @JoinColumn(name = "waste_type", referencedColumnName = "id")
    @ManyToOne(targetEntity = WasteType.class, cascade = CascadeType.ALL)
    private WasteType wasteType;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime lastUpdatedAt;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
