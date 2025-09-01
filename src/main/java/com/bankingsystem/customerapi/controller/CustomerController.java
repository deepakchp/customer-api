package com.bankingsystem.customerapi.controller;

import com.bankingsystem.customerapi.api.CustomersApi;
import com.bankingsystem.customerapi.model.Customer;
import com.bankingsystem.customerapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomersApi {

    @Autowired
    private CustomerService service;

    @Override
    public ResponseEntity<Customer> createCustomer(@Valid Customer customer) {
        return ResponseEntity.status(201).body(service.createCustomer(customer));
    }

    @Override
    public ResponseEntity<List<Customer>> listCustomers(Integer page, Integer limit, String search) {
        return ResponseEntity.ok(service.listCustomers(page, limit, search));
    }

    @Override
    public ResponseEntity<Customer> getCustomer(String customerId) {
        return ResponseEntity.ok(service.getCustomer(customerId));
    }

    /*@Override
    public ResponseEntity<Customer> updateCustomer(String customerId, @Valid Customer customer) {
        return ResponseEntity.ok(service.updateCustomer(customerId, customer));
    }*/

    @Override
    public ResponseEntity<Void> deleteCustomer(String customerId) {
        service.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
}
