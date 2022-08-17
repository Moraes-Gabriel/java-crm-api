package com.example.application.foundation.controller;

import com.example.application.common.exception.BusinessException;
import com.example.application.foundation.controller.request.CustomerRequest;
import com.example.application.foundation.controller.response.CustomerResponse;
import com.example.application.foundation.entity.Customer;
import com.example.application.foundation.mapper.CustomerMapper;
import com.example.application.foundation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.application.common.controller.CommonController;
import com.example.application.common.exception.TechnicalException;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController extends CommonController {

    @Autowired
    private CustomerService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse insertCustomer(@Valid @RequestBody CustomerRequest request) throws TechnicalException {
        return service.insertCustomer(request);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> findById(@PathVariable Long id) throws TechnicalException {
        return this.buildResponse(service.findById(id), HttpStatus.OK);
    }
    @GetMapping("/publico")
    public ResponseEntity<?> getAllCustomer() throws TechnicalException {
        return this.buildResponse(service.getAll(), HttpStatus.OK);
    }
}