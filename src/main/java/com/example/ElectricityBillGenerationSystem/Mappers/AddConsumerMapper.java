package com.example.ElectricityBillGenerationSystem.Mappers;

import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Model.Reading;

public class AddConsumerMapper {

    public static Consumer addConsumerDetails(Consumer consumer){

        return Consumer.builder()
                .name(consumer.getName())
                .email(consumer.getEmail())
                .password(consumer.getPassword())
                .mobNo(consumer.getMobNo())
                .city(consumer.getCity())
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
