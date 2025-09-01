package com.bankingsystem.customerapi.service;

import com.bankingsystem.customerapi.mapper.CustomerMapper;
import com.bankingsystem.customerapi.model.Customer;
import com.bankingsystem.customerapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Customer createCustomer(Customer dto) {
        com.bankingsystem.customerapi.entity.Customer customer = mapper.toEntity(dto);
        customer.setCreatedAt(OffsetDateTime.now());
        customer.setUpdatedAt(OffsetDateTime.now());
        com.bankingsystem.customerapi.entity.Customer saved = repository.save(customer);
        return mapper.toDTO(saved);
    }

    public List<Customer> listCustomers(Integer page, Integer limit, String search) {
        return mapper.toDTOList(repository.findAll());
    }

    public Customer getCustomer(String id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer updateCustomer(String id, Customer dto) {
        com.bankingsystem.customerapi.entity.Customer existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        com.bankingsystem.customerapi.entity.Customer updated = mapper.toEntity(dto);
        updated.setId(existing.getId());
        updated.setCreatedAt(existing.getCreatedAt());
        updated.setUpdatedAt(OffsetDateTime.now());
        return mapper.toDTO(repository.save(updated));
    }

    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }
}
