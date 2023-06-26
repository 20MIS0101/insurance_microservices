package com.example.demo.controller;

import com.example.demo.dto.InsuranceDetailsDTO;
import com.example.demo.io.InsuranceDetailsRequest;
import com.example.demo.io.InsuranceDetailsResponse;
import com.example.demo.service.InsuranceDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class InsuranceDetailsController {
    @Autowired
    private InsuranceDetailsService detailsService;
    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public InsuranceDetailsResponse create(@RequestBody InsuranceDetailsRequest detailsRequest){
        InsuranceDetailsDTO detailsDTO = new InsuranceDetailsDTO();
        BeanUtils.copyProperties(detailsRequest, detailsDTO);

        detailsDTO = detailsService.create(detailsDTO);

        InsuranceDetailsResponse response = new InsuranceDetailsResponse();
        BeanUtils.copyProperties(detailsDTO,response);
        return response;
    }
    @GetMapping("/read/{id}")
    public InsuranceDetailsResponse read(@PathVariable Long id){
        InsuranceDetailsDTO detailsDTO = detailsService.read(id);

        InsuranceDetailsResponse returnValue = new InsuranceDetailsResponse();
        BeanUtils.copyProperties(detailsDTO,returnValue);
        return returnValue;
    }
}
