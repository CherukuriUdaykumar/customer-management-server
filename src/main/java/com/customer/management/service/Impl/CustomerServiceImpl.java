package com.customer.management.service.Impl;

import com.customer.management.dto.CustomerDto;
import com.customer.management.entity.Customer;
import com.customer.management.exception.ResourceNotFoundException;
import com.customer.management.mapper.CustomerMapper;
import com.customer.management.repository.CustomerRepository;
import com.customer.management.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        if (customerRepository.existsByEmail(customerDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        Customer customer = CustomerMapper.mapToCustomerEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }


    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found with id: " + customerId)
        );
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customer = customerRepository.findAll();
        return customer.stream().map(CustomerMapper::mapToCustomerDto).toList();
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto updateCustomerDto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found with id: " + customerId)
        );
        customer.setFirstName(updateCustomerDto.getFirstName());
        customer.setLastName(updateCustomerDto.getLastName());
        customer.setEmail(updateCustomerDto.getEmail());
        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(updatedCustomer);

    }

    @Override
    public CustomerDto deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found with id: " + customerId)
        );
        customerRepository.delete(customer);
        return CustomerMapper.mapToCustomerDto(customer);
    }
}
