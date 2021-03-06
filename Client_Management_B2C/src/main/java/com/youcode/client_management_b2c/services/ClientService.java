package com.youcode.client_management_b2c.services;

import com.youcode.client_management_b2c.entities.Client;
import com.youcode.client_management_b2c.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
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

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public Optional<List<Client>> getClientsByGender(String gender) {
        return clientRepository.findByGender(gender);
    }

    public void deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found");
        }

        client.get().setActive(false);
    }

    public void updateClient(Long id, Client client) {

        Client updateClient = clientRepository.getById(id);

        updateClient.setFullName(client.getFullName());
        updateClient.setEmail(client.getEmail());
        updateClient.setGender(client.getGender());
        updateClient.setPhone(client.getPhone());
        updateClient.setActive(client.isActive());

        clientRepository.save(updateClient);
    }

}
