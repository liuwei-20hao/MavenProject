package com.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2.entity.Customer;
import com.struts2.entity.User;
import com.struts2.service.CustomerService;
import com.struts2.service.impl.CustomerServiceImpl;

public class LoginAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    public String login() throws Exception {
        CustomerService customerService = new CustomerServiceImpl();
        User u = customerService.login(user);
        ActionContext.getContext().getSession().put("user", u);
        return "toHome";
    }
    public User getModel() {
        return user;
    }
}
