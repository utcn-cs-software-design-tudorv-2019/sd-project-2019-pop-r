package com.eventsweb.eventsweb.service;

import com.eventsweb.eventsweb.model.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);
    Client getClientById(int clientId);
    List<Client> getAllClients();

    Client getClientByUsername(String username);
}