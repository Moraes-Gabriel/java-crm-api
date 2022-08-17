package com.example.application.foundation.service.searsh;

import com.example.application.common.exception.BusinessException;
import com.example.application.common.exception.TechnicalException;
import com.example.application.foundation.entity.Customer;
import com.example.application.foundation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class SearshCustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer byId(Long id) throws BusinessException {
            return repository.findById(id)
                    .orElseThrow(() -> new BusinessException("Item not found", NOT_FOUND));
    }
}
