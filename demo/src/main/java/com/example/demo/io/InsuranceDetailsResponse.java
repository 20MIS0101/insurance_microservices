package com.example.demo.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDetailsResponse {
    private Long id;
    private String policyName;
    private String policyNumber;

    private String companyName;
    private String description;

    private Double premiumAmount;
}
