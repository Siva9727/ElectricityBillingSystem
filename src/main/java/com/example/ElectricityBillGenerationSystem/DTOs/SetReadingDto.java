package com.example.ElectricityBillGenerationSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetReadingDto {

//    currentReading}/{date}/{customerId}/{adminId}

    private int currentReading;

    private String date;

    private int consumerId;

    private int adminId;

}
