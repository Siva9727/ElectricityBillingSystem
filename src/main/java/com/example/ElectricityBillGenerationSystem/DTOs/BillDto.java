package com.example.ElectricityBillGenerationSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDto {

    @CreationTimestamp
    Date billGeneratedOn;

    private String Customer_Name;

    private int Customer_ID;

    private double Consumption_Units;

    private String Period;

    private double Bill_Amount;

}
