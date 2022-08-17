package com.example.application.foundation.service;

import com.example.application.common.exception.BusinessException;
import com.example.application.common.exception.TechnicalException;
import com.example.application.foundation.controller.request.CustomerRequest;
import com.example.application.foundation.controller.response.CustomerResponse;
import com.example.application.foundation.entity.Customer;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface CustomerService {
	
    /**
     * Gets customer data by id
     * @param id
     * @return item
     * @throws **BusinessException
     * @throws **TechnicalException
     */
    CustomerResponse findById(@NotEmpty Long id) throws TechnicalException;

    CustomerResponse insertCustomer(CustomerRequest request) throws TechnicalException;

    List<CustomerResponse> getAll() throws TechnicalException;
}
