package com.example.demo.service;

import com.example.demo.dto.InsuranceDetailsDTO;
import com.example.demo.repository.InsuranceDetailsRepository;
import com.example.demo.entity.InsuranceDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceDetailsService {
    @Autowired
    private InsuranceDetailsRepository detailsRepository;
    public InsuranceDetailsDTO create(InsuranceDetailsDTO detailsDTO){
        InsuranceDetails details = new InsuranceDetails();
        BeanUtils.copyProperties(detailsDTO,details);
        details = detailsRepository.save(details);
        BeanUtils.copyProperties(details,detailsDTO);
        return detailsDTO;
    }

    public InsuranceDetailsDTO read(Long id){
        InsuranceDetailsDTO returnValue = new InsuranceDetailsDTO();
        InsuranceDetails details = detailsRepository.findById(id).get();
        BeanUtils.copyProperties(details,returnValue);
        return returnValue;

    }
}
