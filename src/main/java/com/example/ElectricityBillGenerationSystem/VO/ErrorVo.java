package com.example.ElectricityBillGenerationSystem.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorVo {

    private String fieldName;
    private List<String> message;

}
