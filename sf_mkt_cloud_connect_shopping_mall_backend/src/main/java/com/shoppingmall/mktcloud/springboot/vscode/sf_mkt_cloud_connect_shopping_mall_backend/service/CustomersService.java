package com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.service;

import com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.model.Customers;
import com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomersService.class);

    public List<Customers> findAll() {
        List<Customers> customers = customerRepository.findAll();
        logger.debug("Found {} customers", customers.size());
        return customers;
    }

    public Customers save(Customers customer) {
        return customerRepository.save(customer);
    }
    
    public Customers findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
