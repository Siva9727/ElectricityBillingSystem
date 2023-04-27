package com.example.ElectricityBillGenerationSystem.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsumerDto {

    @NotNull(message = "name field cannot be blank or null")
    private String name;

    @Email(message = "Provide valid email address")
    private String email;

    @NotNull
    @Size(min = 4, max = 20)
    private String password;

    @NotBlank(message = "City field cannot be blank")
    private String city;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "mobile number should contain 10 digits")
    private String mobNo;


}
