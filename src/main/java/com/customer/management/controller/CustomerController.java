package com.customer.management.controller;

import com.customer.management.dto.CustomerDto;
import com.customer.management.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Customer Management", description = "CRUD operations for managing customers")
@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @Operation(summary = "Create a new customer", description = "Adds a new customer to the system")
    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(
            @RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @Operation(summary = "Get customer by ID", description = "Retrieves a customer using their unique ID")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(
            @Parameter(description = "ID of the customer to retrieve") @PathVariable("id") Long customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @Operation(summary = "Get all customers", description = "Returns a list of all customers")
    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @Operation(summary = "Update customer", description = "Updates an existing customer's details")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(
            @Parameter(description = "ID of the customer to update") @PathVariable("id") Long customerId,
            @RequestBody CustomerDto updateCustomerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerId, updateCustomerDto);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @Operation(summary = "Delete customer", description = "Deletes a customer by their ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(
            @Parameter(description = "ID of the customer to delete") @PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted successfully.");
    }
}