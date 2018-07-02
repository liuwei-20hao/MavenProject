package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Named;


public class DemoAction extends ActionSupport{
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
        System.out.println("get");
        return "success";
    }

    public static class HelloAction {
        public String hello(){
            System.out.println("hello world");
            return "success";
        }
    }
}
