package com.example.ElectricityBillGenerationSystem.Repository;

import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Integer> {


}
