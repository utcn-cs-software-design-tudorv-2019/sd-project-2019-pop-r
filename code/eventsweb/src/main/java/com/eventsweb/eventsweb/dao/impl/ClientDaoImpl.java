package com.eventsweb.eventsweb.dao.impl;

import com.eventsweb.eventsweb.dao.ClientDao;
import com.eventsweb.eventsweb.model.Authorities;
import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.Client;
import com.eventsweb.eventsweb.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        client.getBillingAddress().setCustomer(client);
        client.getShippingAddress().setCustomer(client);

        session.saveOrUpdate(client);
        session.saveOrUpdate(client.getBillingAddress());
        session.saveOrUpdate((client.getShippingAddress()));

        Users newUser = new Users();
        newUser.setUsername(client.getUsername());
        newUser.setPassword(client.getPassword());
        newUser.setEnabled(true);
        newUser.setClientId(client.getClientId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(client.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart newCart = new Cart();
        newCart.setClient(client);
        client.setCart(newCart);
        session.saveOrUpdate(client);
        session.saveOrUpdate(newCart);

        session.flush();

    }

    @Override
    public Client getClientById(int clientId) {
        Session session = sessionFactory.getCurrentSession();
        return (Client) session.get(Client.class, clientId);
    }

    @Override
    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client");
        List<Client> clientList = query.list();

        return clientList;
    }

    @Override
    public Client getClientByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client WHERE username = ?");
        query.setString(0, username);
        return (Client) query.uniqueResult();
    }
}
