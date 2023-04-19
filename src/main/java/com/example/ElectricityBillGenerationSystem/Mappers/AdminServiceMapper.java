package com.example.ElectricityBillGenerationSystem.Mappers;

import com.example.ElectricityBillGenerationSystem.DTOs.SetReadingDto;
import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Model.Reading;

public class AdminServiceMapper {

    public static Reading reading(SetReadingDto setReadingDto, Admin admin, Consumer consumer){
        return Reading.builder()
                .CurrentReading(setReadingDto.getCurrentReading())
                .admin(admin)
                .consumer(consumer)
                .build();
    }
}
