package com.struts2.dao.impl;

import com.struts2.HibernateUtils;
import com.struts2.dao.CustomerDao;
import com.struts2.entity.Customer;
import org.hibernate.*;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    private SessionFactory sessionFactory;
    public List<Customer> getCustomer() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createSQLQuery("select * from cst_customer ");
        List<Customer> list = q.list();
        tx.commit();
        session.close();
        return list;
    }

    public void addCustomer(Customer c) {
        sessionFactory.getCurrentSession().save(c);
    }

    public void delCustomer(Customer c) {
        sessionFactory.getCurrentSession().delete(c);
    }

    public void modCustomer(Customer c) {
        sessionFactory.getCurrentSession().update(c);
    }
}
