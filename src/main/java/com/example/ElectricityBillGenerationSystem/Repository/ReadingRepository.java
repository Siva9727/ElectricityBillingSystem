package com.example.ElectricityBillGenerationSystem.Repository;

import com.example.ElectricityBillGenerationSystem.Model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Integer> {

    @Query(value = "select * from reading where consumer_id = :value ORDER BY reading_date DESC LIMIT 2", nativeQuery = true)
    List<Reading> findLatestTwoReadingsByConsumerId(@Param("value") int consumerId);
}
