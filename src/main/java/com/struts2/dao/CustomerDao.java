package com.struts2.dao;

import com.struts2.entity.Customer;
import com.struts2.entity.User;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getCustomer();

    public List<Customer> getCustomerByName(String name);

    public void addCustomer(Customer c);

    public void delCustomer(Customer c);

    public void modCustomer(Customer c);

    public User login(User u);
}
