package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDetailsDTO {
    private Long id;
    private String policyName;
    private String policyNumber;

    private String companyName;
    private String description;

    private Double premiumAmount;
}
