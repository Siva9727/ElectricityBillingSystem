package com.example.ElectricityBillGenerationSystem.Controller;

import com.example.ElectricityBillGenerationSystem.DTOs.BillDto;
import com.example.ElectricityBillGenerationSystem.DTOs.UpdateConsumerDto;
import com.example.ElectricityBillGenerationSystem.Model.Bill;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping("/add-consumer")
    public String addConsumer(@RequestBody Consumer consumer){
        return consumerService.addConsumer(consumer);
    }

    @GetMapping("/get-bill/{id}")
    public BillDto generateBill(@PathVariable int id){
        return consumerService.generateBill(id);
    }

    // update
    @PutMapping("/update")
    public String updateConsumerDetails(@RequestBody UpdateConsumerDto updateConsumerDto){

        return consumerService.updateConsumerDetails(updateConsumerDto);

    }



}
