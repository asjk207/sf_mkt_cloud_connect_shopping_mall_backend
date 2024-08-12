package com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.controller;

import com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.model.Customers;
import com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomersService customerService;

    private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

    @GetMapping
    public List<Customers> getAllCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer) {
        Customers createdCustomer = customerService.save(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@RequestParam("id")@PathVariable Long id) {
        Customers customer = customerService.findById(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@RequestParam("id")@PathVariable Long id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

