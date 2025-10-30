package com.customer.management.controller;

import com.customer.management.dto.CustomerDto;
import com.customer.management.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    //Build Add Customer REST API
    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    //Build Get Customer by ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    //Build Get All Customers REST API
    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //Build Update Customer REST API
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long customerId, @RequestBody CustomerDto updateCustomerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerId, updateCustomerDto);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);

    }

    //Build Delete Customer REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted successfully.");
    }
}