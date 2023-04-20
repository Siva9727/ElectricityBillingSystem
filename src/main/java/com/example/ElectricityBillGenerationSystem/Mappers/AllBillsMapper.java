package com.example.ElectricityBillGenerationSystem.Mappers;

import com.example.ElectricityBillGenerationSystem.DTOs.BillDto;
import com.example.ElectricityBillGenerationSystem.Model.Bill;

public class AllBillsMapper {

    public static BillDto getDto(Bill bill){
        return BillDto.builder()
                .Bill_Amount(bill.getBill_Amount())
                .billGeneratedOn(bill.getBillGeneratedOn())
                .Consumption_Units(bill.getConsumption_Units())
                .Customer_ID(bill.getConsumer().getId())
                .Customer_Name(bill.getCustomer_Name())
                .Period(bill.getPeriod())
                .build();

    }
}
