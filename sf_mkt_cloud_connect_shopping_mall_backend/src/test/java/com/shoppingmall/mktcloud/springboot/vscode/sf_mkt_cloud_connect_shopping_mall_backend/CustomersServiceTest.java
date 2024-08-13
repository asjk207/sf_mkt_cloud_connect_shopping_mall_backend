package com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend;

import com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.model.Customers;
import com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.repository.CustomersRepository;
import com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.service.CustomersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomersServiceTest {

    @Mock
    private CustomersRepository customersRepository;

    @InjectMocks
    private CustomersService customersService;

    private Customers customer1;
    private Customers customer2;

    @BeforeEach
    void setUp() {
        customer1 = new Customers();
        customer1.setId(1L);
        customer1.setLastName("John");
        customer1.setFirstName("Doe");

        customer2 = new Customers();
        customer2.setId(2L);
        customer2.setLastName("Jane");
        customer2.setFirstName("Smith");
    }

    @Test
    void testFindAll() {
        List<Customers> customersList = Arrays.asList(customer1, customer2);

        when(customersRepository.findAll()).thenReturn(customersList);

        List<Customers> result = customersService.findAll();
        assertEquals(2, result.size());
        assertEquals("Doe", result.get(0).getFirstName());
        assertEquals("John", result.get(0).getLastName());
        assertEquals("Smith", result.get(1).getFirstName());
        assertEquals("Jane", result.get(1).getLastName());

        verify(customersRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(customersRepository.findById(1L)).thenReturn(Optional.of(customer1));

        Customers result = customersService.findById(1L);
        assertNotNull(result);
        assertEquals("Doe", result.getFirstName());
        assertEquals("John", result.getLastName());

        verify(customersRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        when(customersRepository.findById(3L)).thenReturn(Optional.empty());

        Customers result = customersService.findById(3L);
        assertNull(result);

        verify(customersRepository, times(1)).findById(3L);
    }

    @Test
    void testSave() {
        when(customersRepository.save(customer1)).thenReturn(customer1);

        Customers result = customersService.save(customer1);
        assertNotNull(result);
        assertEquals("Doe", result.getFirstName());
        assertEquals("John", result.getLastName());

        verify(customersRepository, times(1)).save(customer1);
    }

    @Test
    void testDeleteById() {
        doNothing().when(customersRepository).deleteById(1L);

        customersService.deleteById(1L);
        
        verify(customersRepository, times(1)).deleteById(1L);
    }
}