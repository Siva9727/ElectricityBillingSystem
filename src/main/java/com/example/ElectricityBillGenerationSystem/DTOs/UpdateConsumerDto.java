package com.example.ElectricityBillGenerationSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConsumerDto {

    private int id;


    private String name;

    private String email;

    private String password;

    private String city;

    private String mobNo;

}
