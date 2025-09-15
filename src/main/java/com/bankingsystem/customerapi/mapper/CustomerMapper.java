package com.bankingsystem.customerapi.mapper;

import com.bankingsystem.customerapi.model.Address;
import com.bankingsystem.customerapi.entity.Customer;
import com.bankingsystem.customerapi.model.CustomerDto;
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
    Customer toEntity(CustomerDto dto);

    com.bankingsystem.customerapi.entity.Address toEntity(Address dto);

    CustomerDto toDTO(Customer customer);

    Address toDTO(com.bankingsystem.customerapi.entity.Address address);

    List<CustomerDto> toDTOList(List<Customer> customers);


}
