package com.example.ElectricityBillGenerationSystem.Mappers;

import com.example.ElectricityBillGenerationSystem.DTOs.BillDto;
import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Bill;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;

public class BillGenerationMapper {

    public static Bill generate(BillDto bill, Admin admin, Consumer consumer){
        return Bill.builder()
                .billGeneratedOn(bill.getBillGeneratedOn())
                .Bill_Amount(bill.getBill_Amount())
                .admin(admin)
                .consumer(consumer)
                .Consumption_Units(bill.getConsumption_Units())
                .Customer_Name(consumer.getName())
                .Period(bill.getPeriod())
                .build();
    }
}
