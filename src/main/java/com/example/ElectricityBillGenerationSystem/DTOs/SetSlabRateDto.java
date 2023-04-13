package com.example.ElectricityBillGenerationSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetSlabRateDto {

    private double minUnit;

    private double maxUnit;

    private double Slab_Rate;

    private int adminId;

}
