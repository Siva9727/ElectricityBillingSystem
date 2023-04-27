package com.example.ElectricityBillGenerationSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetSlabRateDto {

    @NotNull(message = "provide valid min unit")
    private double minUnit;

    @NotNull(message = "provide valid max unit")
    private double maxUnit;

    @NotNull(message = "provide valid slab rate for the range of units")
    private double Slab_Rate;

    private int adminId;

}
