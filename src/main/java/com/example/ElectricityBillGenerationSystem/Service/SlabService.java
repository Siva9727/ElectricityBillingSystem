package com.example.ElectricityBillGenerationSystem.Service;

import com.example.ElectricityBillGenerationSystem.DTOs.SetSlabRateDto;
import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Slab;
import com.example.ElectricityBillGenerationSystem.Repository.AdminRepository;
import com.example.ElectricityBillGenerationSystem.Repository.SlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlabService {
    @Autowired
    SlabRepository slabRepository;

    @Autowired
    AdminRepository adminRepository;

    public String setSlabRate(SetSlabRateDto setSlabRateDto){
        Slab slab = new Slab();

        slab.setMinUnit(setSlabRateDto.getMinUnit());
        slab.setMaxUnit(setSlabRateDto.getMaxUnit());
        slab.setSlab_Rate(setSlabRateDto.getSlab_Rate());

        Admin admin = adminRepository.findById(setSlabRateDto.getAdminId()).get();

        slab.setAdmin(admin);

        slabRepository.save(slab);

        return "Slab rate set Successfully!";
    }
}




























