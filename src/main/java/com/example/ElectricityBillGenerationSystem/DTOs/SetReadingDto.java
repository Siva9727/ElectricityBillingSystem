package com.example.ElectricityBillGenerationSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetReadingDto {

//    currentReading}/{date}/{customerId}/{adminId}

    @NotNull(message = "provide current reading")
    private int currentReading;

    private String date;

    private int consumerId;

    private int adminId;

}
