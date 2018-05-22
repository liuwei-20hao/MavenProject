package com.struts2.service.impl;

import com.struts2.dao.CustomerDao;
import com.struts2.dao.impl.CustomerDaoImpl;
import com.struts2.entity.Customer;
import com.struts2.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    public List<Customer> getCustomer() {
        CustomerDao customerDao = new CustomerDaoImpl();
        return customerDao.getCustomer();
    }

    public void addCustomer(Customer c) {
        customerDao.addCustomer(c);
    }

    public void delCustomer(Customer c) {
        customerDao.delCustomer(c);
    }

    public void modCustomer(Customer c) {
        customerDao.modCustomer(c);
    }
}
