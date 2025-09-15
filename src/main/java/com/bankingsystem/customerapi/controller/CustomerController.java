package com.bankingsystem.customerapi.controller;

import com.bankingsystem.customerapi.api.CustomersApi;
import com.bankingsystem.customerapi.entity.Customer;
import com.bankingsystem.customerapi.model.CustomerDto;
import com.bankingsystem.customerapi.service.CustomerService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomersApi {

    @Autowired
    private CustomerService service;

    @Override
    public ResponseEntity<CustomerDto> createCustomer(@Valid CustomerDto customer) {
        return ResponseEntity.status(201).body(service.createCustomer(customer));
    }

    @Override
    public ResponseEntity<List<CustomerDto>> listCustomers(Integer page, Integer limit, String search) {
        return ResponseEntity.ok(service.listCustomers(page, limit, search));
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomer(String customerId) {
        return ResponseEntity.ok(service.getCustomer(customerId));
    }

 /*   @Override
    public ResponseEntity<Customer> updateCustomer(String customerId, @Valid Customer customer) {
        return ResponseEntity.ok(service.updateCustomer(customerId, customer));
    }*/

    public ResponseEntity<Void> updateCustomer(String customerId,CustomerDto customer) {
        service.updateCustomer(customerId, customer);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(String customerId) {
        service.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
}
