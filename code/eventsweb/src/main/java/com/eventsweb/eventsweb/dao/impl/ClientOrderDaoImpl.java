package com.eventsweb.eventsweb.dao.impl;

import com.eventsweb.eventsweb.dao.ClientOrderDao;
import com.eventsweb.eventsweb.model.ClientOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientOrderDaoImpl implements ClientOrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addClientOrder(ClientOrder clientOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(clientOrder);
        session.flush();
    }
}
