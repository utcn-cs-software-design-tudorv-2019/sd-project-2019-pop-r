package com.eventsweb.eventsweb.service.impl;

import com.eventsweb.eventsweb.dao.ClientDao;
import com.eventsweb.eventsweb.model.Client;
import com.eventsweb.eventsweb.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    @Override
    public Client getClientById(int clientId) {
        return clientDao.getClientById(clientId);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    @Override
    public Client getClientByUsername(String username) {
        return clientDao.getClientByUsername(username);
    }
}
