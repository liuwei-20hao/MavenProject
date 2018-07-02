package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ModelDriven;
import com.struts2.entity.Customer;
import com.struts2.service.CustomerService;
import com.struts2.service.impl.CustomerServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    private Customer customer =new Customer();
    //获得spring容器=>从Application域获得即可

    //1 获得servletContext对象
    ServletContext sc = ServletActionContext.getServletContext();
    //2.从Sc中获得ac容器
    WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
    //3.从容器中获得CustomerService
    CustomerService cs = (CustomerService) ac.getBean("customerService");
    public String add(){
        cs.addCustomer(customer);
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
        List<Customer> cus = cs.getCustomerByName(name);
        ServletActionContext.getRequest().setAttribute("list",cus);
        return "list";
    }

    public Customer getModel() {
        return customer;
    }
}
