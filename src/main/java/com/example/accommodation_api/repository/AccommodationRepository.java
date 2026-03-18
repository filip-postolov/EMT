package com.example.accommodation_api.repository;

import com.example.accommodation_api.model.Accommodation;
import com.example.accommodation_api.model.enums.AccommodationCategory;
import com.example.accommodation_api.model.enums.AccommodationCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    List<Accommodation> findAllByCondition(AccommodationCondition condition);

    List<Accommodation> findAllByCategory(AccommodationCategory category);

    List<Accommodation> findAllByIsRented(Boolean isRented);
}