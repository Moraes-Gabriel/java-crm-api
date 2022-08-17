package com.example.application.foundation.mapper;


import com.example.application.foundation.controller.request.CustomerRequest;
import com.example.application.foundation.controller.response.CustomerResponse;
import com.example.application.foundation.entity.Customer;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerResponse toResponse(Customer entity) {
        return new ModelMapper().map(entity, CustomerResponse.class);
    }
    public static List<CustomerResponse> toResponse(List<Customer> entity){
        return entity.stream().map(CustomerMapper::toResponse).collect(Collectors.toList());
    }
    public static Customer toEntity(CustomerRequest request) {
        return new ModelMapper().map(request, Customer.class);
    }


}

