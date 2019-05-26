package com.eventsweb.eventsweb.dao;

import com.eventsweb.eventsweb.model.Client;

import java.util.List;

public interface ClientDao {
    void addClient(Client client);
    Client getClientById(int clientId);
    List<Client> getAllClients();

    Client getClientByUsername(String username);
}