package com.struts2.service.impl;

import com.struts2.dao.CustomerDao;
import com.struts2.dao.impl.CustomerDaoImpl;
import com.struts2.entity.Customer;
import com.struts2.entity.User;
import com.struts2.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    public List<Customer> getCustomer() {
        CustomerDao customerDao = new CustomerDaoImpl();
        return customerDao.getCustomer();
    }

    public List<Customer> getCustomerByName(String name) {
        customerDao = new CustomerDaoImpl();
        return customerDao.getCustomerByName(name);
    }

    public void addCustomer(Customer c) {
        customerDao = new CustomerDaoImpl();
        customerDao.addCustomer(c);
    }

    public void delCustomer(Customer c) {
        customerDao.delCustomer(c);
    }

    public void modCustomer(Customer c) {
        customerDao.modCustomer(c);
    }

    public User login(User u) {
        customerDao = new CustomerDaoImpl();
        User existU=customerDao.login(u);
        if(existU==null){
            //获得不到=>抛出异常提示用户名不存在
            throw new RuntimeException("用户名不存在!");
        }
        //2 比对密码是否一致
        if(!existU.getUser_pwd().equals(u.getUser_pwd())){
            //不一致=>抛出异常提示密码错误
            throw new RuntimeException("密码错误!");
        }
        return customerDao.login(u);
    }
}
