package com.example.ElectricityBillGenerationSystem.Controller;

import com.example.ElectricityBillGenerationSystem.DTOs.*;
import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Bill;
import com.example.ElectricityBillGenerationSystem.Model.Slab;
import com.example.ElectricityBillGenerationSystem.Service.AdminService;
import com.example.ElectricityBillGenerationSystem.Service.SlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    SlabService slabService;


    @PostMapping("/register")
    public String registerAdmin(@RequestBody Admin admin){
        return adminService.registerAdmin(admin);
    }

    @PostMapping("/set-slab-rate")
    public String setSlabRate(@RequestBody SetSlabRateDto setSlabRateDto){
        return slabService.setSlabRate(setSlabRateDto);
    }

   @PostMapping("/set-reading")
    public  String setReading(@RequestBody SetReadingDto setReadingDto){
        return adminService.setReading(setReadingDto);
   }

    @PutMapping("/update")
    public String updateConsumerDetails(@RequestBody UpdateConsumerDto updateConsumerDto){

        return adminService.updateConsumerDetails(updateConsumerDto);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return adminService.deleteUser(id);
    }


    @PutMapping("/update-slab-rate")
    public String updateSlab(@RequestBody UpdateSlabRequestDto updateSlabRequestDto){

        return adminService.updateSlab(updateSlabRequestDto);
    }

    @GetMapping("/all-bills")
    public List<BillDto> getAllBills(){
        return adminService.getAllBills();
    }

}
