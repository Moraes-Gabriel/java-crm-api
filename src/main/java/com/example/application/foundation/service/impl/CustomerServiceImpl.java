package com.example.application.foundation.service.impl;

import com.example.application.common.exception.TechnicalException;
import com.example.application.foundation.controller.request.CustomerRequest;
import com.example.application.foundation.controller.response.CustomerResponse;
import com.example.application.foundation.mapper.CustomerMapper;
import com.example.application.foundation.service.CustomerService;
import com.example.application.foundation.service.searsh.SearshCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.foundation.entity.Customer;
import com.example.application.foundation.repository.CustomerRepository;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
	
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private SearshCustomerService searshCustomerService;

    @Override
    public CustomerResponse findById(@NotEmpty Long id) throws TechnicalException {
        try {
            return CustomerMapper.toResponse(searshCustomerService.byId(id));
        } catch (Exception e) {
            throw new TechnicalException(e);
        }
    }

    @Override
    public CustomerResponse insertCustomer(CustomerRequest request) throws TechnicalException {
        Customer entity = CustomerMapper.toEntity(request);
        try {
            repository.save(entity);
        } catch (Exception e) {
            throw new TechnicalException(e);
        }
        return CustomerMapper.toResponse(entity);
    }

    @Override
    public List<CustomerResponse> getAll() throws TechnicalException {
        try {
            return CustomerMapper.toResponse(repository.findAll());
        } catch (Exception e) {
            throw new TechnicalException(e);
        }
    }
}
