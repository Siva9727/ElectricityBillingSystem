package com.example.ElectricityBillGenerationSystem.Mappers;

import com.example.ElectricityBillGenerationSystem.DTOs.BillDto;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;

public class BillDtoMapper {

    public static BillDto BillDtoGeneration(int id, Consumer consumer, double units, double bill_amount, String period){
        return BillDto.builder()
                .Customer_ID(id)
                .Customer_Name(consumer.getName())
                .Consumption_Units(units)
                .Bill_Amount(bill_amount)
                .Period(period)
                .build();
    }
}
