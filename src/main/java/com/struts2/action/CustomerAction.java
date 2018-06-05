package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Inject;

import com.opensymphony.xwork2.ModelDriven;
import com.struts2.entity.Customer;
import com.struts2.service.CustomerService;
import com.struts2.service.impl.CustomerServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    private Customer customer =new Customer();
    public String add(){
        CustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(customer);
        return "tolist";
    }
    public String del(){
        System.out.println("del");
        return "success";
    }
    public String mod(){
        System.out.println("mod");
        return "success";
    }
    public String get(){
        String name = ServletActionContext.getRequest().getParameter("cust_name");
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> cus = customerService.getCustomerByName(name);
        ServletActionContext.getRequest().setAttribute("list",cus);
        return "list";
    }

    public Customer getModel() {
        return customer;
    }
}
