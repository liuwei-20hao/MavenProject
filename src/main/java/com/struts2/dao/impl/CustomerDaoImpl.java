package com.struts2.dao.impl;

import com.struts2.HibernateUtils;
import com.struts2.dao.CustomerDao;
import com.struts2.entity.Customer;
import com.struts2.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.*;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    private SessionFactory sessionFactory;
    public List<Customer> getCustomer() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        StringBuffer sql = new StringBuffer("select * from cst_customer c where 1=1");
        SQLQuery q = session.createSQLQuery(sql.toString());
        q.addEntity(Customer.class);
        List<Customer> list = q.list();
        tx.commit();
        session.close();
        return list;
    }

    public List<Customer> getCustomerByName(String name) {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        StringBuffer sql = new StringBuffer("select * from cst_customer c where 1=1");
        List<Object> p = new ArrayList<Object>();
        if(StringUtils.isNotEmpty(name)){
            sql.append(" and c.cust_name like ?");
            p.add("%"+name+"%");
        }
        SQLQuery q = session.createSQLQuery(sql.toString());
        for(int i=0;i<p.size();i++){
            q.setParameter(i,p.get(i));
        }
        q.addEntity(Customer.class);
        List<Customer> list = q.list();
        tx.commit();
        session.close();
        return list;
    }

    public void addCustomer(Customer c) {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    public void delCustomer(Customer c) {
        sessionFactory.getCurrentSession().delete(c);
    }

    public void modCustomer(Customer c) {
        sessionFactory.getCurrentSession().update(c);
    }

    public User login(User u) {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //2 书写HQL
        String sql = "select * from sys_user where user_name = ? ";
        //3 创建查询对象
        SQLQuery query = session.createSQLQuery(sql);
        //4 设置参数
        query.setParameter(0, u.getUser_name());
        //5 执行查询
        query.addEntity(User.class);
        User ue = (User) query.uniqueResult();
        tx.commit();
        session.close();
        return ue;
    }
}
