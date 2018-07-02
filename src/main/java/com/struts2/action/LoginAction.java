package com.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.entity.User;
import com.struts2.service.CustomerService;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.inject.Named;
import javax.servlet.ServletContext;

public class LoginAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    public String login() throws Exception {
        //获得spring容器=>从Application域获得即可

        //1 获得servletContext对象
        ServletContext sc = ServletActionContext.getServletContext();
        //2.从Sc中获得ac容器
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        //3.从容器中获得CustomerService
        CustomerService us = (CustomerService) ac.getBean("customerService");
        //-----------------------------------------------------------------------------------
        //1 调用Service 执行登陆操作
        User u = us.login(user);
        //2 将返回的User对象放入session域作为登陆标识
        ActionContext.getContext().getSession().put("user", u);
        //3 重定向到项目的首页
        return "toHome";
    }
    public User getModel() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
