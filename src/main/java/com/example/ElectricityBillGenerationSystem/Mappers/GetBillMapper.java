package com.example.ElectricityBillGenerationSystem.Mappers;

import com.example.ElectricityBillGenerationSystem.DTOs.BillDto;
import com.example.ElectricityBillGenerationSystem.Model.Bill;

public class GetBillMapper {

    public static BillDto getBillMapping(Bill bill){
        return BillDto.builder()
                .Bill_Amount(bill.getBill_Amount())
                .Period(bill.getPeriod())
                .Customer_ID(bill.getConsumer().getId())
                .Customer_Name(bill.getCustomer_Name())
                .billGeneratedOn(bill.getBillGeneratedOn())
                .Consumption_Units(bill.getConsumption_Units())
                .build();
    }
}
