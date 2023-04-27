package com.example.ElectricityBillGenerationSystem.Mappers;

import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Model.Reading;
import com.example.ElectricityBillGenerationSystem.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AddConsumerMapper {

    @Autowired
    AdminRepository adminRepository;

    public static Consumer addConsumerDetails(Consumer consumerDto){

        return Consumer.builder()
                .name(consumerDto.getName())
                .email(consumerDto.getEmail())
                .password(consumerDto.getPassword())
                .mobNo(consumerDto.getMobNo())
                .city(consumerDto.getCity())
                .build();
    }

    public static Reading setInitialReading(Consumer consumer, Admin admin){
        return Reading.builder()
                .consumer(consumer)
                .CurrentReading(0)
                .admin(admin)
                .build();
    }
}
