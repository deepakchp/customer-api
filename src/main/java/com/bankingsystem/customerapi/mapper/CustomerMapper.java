package com.bankingsystem.customerapi.mapper;

import com.bankingsystem.customerapi.model.Customer;
import com.bankingsystem.customerapi.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    // DTO → Entity
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    com.bankingsystem.customerapi.entity.Customer toEntity(Customer dto);

    com.bankingsystem.customerapi.entity.Address toEntity(Address dto);

    Customer toDTO(com.bankingsystem.customerapi.entity.Customer customer);

    Address toDTO(com.bankingsystem.customerapi.entity.Address address);

    List<Customer> toDTOList(List<com.bankingsystem.customerapi.entity.Customer> customers);


}
