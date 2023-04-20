package com.example.ElectricityBillGenerationSystem.Mappers;

import com.example.ElectricityBillGenerationSystem.DTOs.UpdateConsumerDto;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateConsumerMapper {

    @Autowired
    static ConsumerRepository consumerRepository;

    public static Consumer updateConsumer(UpdateConsumerDto updateConsumerDto){

        Consumer originalConsumer = consumerRepository.findById(updateConsumerDto.getId()).get();

        originalConsumer.setCity(updateConsumerDto.getCity());
        originalConsumer.setMobNo(updateConsumerDto.getMobNo());
        originalConsumer.setName(updateConsumerDto.getName());
        originalConsumer.setEmail(updateConsumerDto.getEmail());
        originalConsumer.setPassword(updateConsumerDto.getPassword());

        return originalConsumer;
    }
}
