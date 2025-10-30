package com.customer.management.mapper;

import com.customer.management.dto.CustomerDto;
import com.customer.management.entity.Customer;


public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }

    public static Customer mapToCustomerEntity(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail()
        );
    }
}
