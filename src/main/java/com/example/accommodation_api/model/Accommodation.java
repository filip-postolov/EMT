package com.example.accommodation_api.model;



import com.example.accommodation_api.model.enums.AccommodationCategory;
import com.example.accommodation_api.model.enums.AccommodationCondition;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "accommodation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false, length = 200)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private AccommodationCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition", nullable = false, length = 10)
    @Builder.Default
    private AccommodationCondition condition = AccommodationCondition.GOOD;

    @Column(name = "is_rented", nullable = false)
    @Builder.Default
    private Boolean isRented = false;

    @Column(name = "num_rooms", nullable = false)
    private Integer numRooms;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;
}