package com.customer.management.service;

import com.customer.management.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long customerId);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long customerId, CustomerDto UpdateCustomerDto);
    CustomerDto deleteCustomer(Long customerId);

}
