package com.youcode.client_management_b2c.services;

import com.youcode.client_management_b2c.entities.Client;
import com.youcode.client_management_b2c.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client save(Client client){

        Optional<Client> email =clientRepository.findByEmail(client.getEmail());
        if (email.isPresent()){
            throw new IllegalStateException("email taken");
        }
        return clientRepository.save(client);
    }
}
