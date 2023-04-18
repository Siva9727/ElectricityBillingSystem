package com.example.ElectricityBillGenerationSystem.Repository;

import com.example.ElectricityBillGenerationSystem.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Query(value = "select * from bill where consumer_id = :value ORDER BY bill_generated_on DESC LIMIT 1",nativeQuery = true)
    Bill findBillByConsumerId(@Param("value")int id);

    @Query(value = "select * from bill order by consumer_id",nativeQuery = true)
    List<Bill> getAllBills();

    @Query(value = "select * from bill where admin_id = :value",nativeQuery = true)
    List<Bill> findAllBillsByAdminId(@Param("value")int id);

//    @Query("SELECT b FROM Bill b WHERE b.consumer.id = :value ORDER BY b.billGeneratedOn DESC")
//    Bill findBillByConsumerId(@Param("value") int id);
//
//    @Query("SELECT b FROM Bill b ORDER BY b.consumer.id")
//    List<Bill> getAllBills();
//
//    @Query("SELECT b FROM Bill b WHERE b.admin.id = :value")
//    List<Bill> findAllBillsByAdminId(@Param("value") int id);

}
