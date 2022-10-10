package com.program.dashboard.service;

import com.program.dashboard.dao.CustomerDAO;
import com.program.dashboard.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomers() {

        List<Customer> customers = customerDAO.getCustomers();
        return customers;


    }
}
