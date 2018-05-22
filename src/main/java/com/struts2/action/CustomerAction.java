package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Inject;
import com.struts2.entity.Customer;
import com.struts2.service.CustomerService;
import com.struts2.service.impl.CustomerServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class CustomerAction extends ActionSupport {
    @Inject
    private CustomerService customerService;
    public String add(){
        System.out.println("add");
        return "success";
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
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> cus = customerService.getCustomer();
        ServletActionContext.getRequest().setAttribute("list",cus);
        System.out.println(cus);
        return "list";
    }
}
